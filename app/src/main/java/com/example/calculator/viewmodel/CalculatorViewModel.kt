package com.example.calculator.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculator.model.CalculatorState
import com.example.calculator.util.ExpressionParser

class CalculatorViewModel : ViewModel() {
    private val _calculatorState = mutableStateOf(CalculatorState())
    val calculatorState: State<CalculatorState> = _calculatorState

    private var canAddOperation = false
    private var canAddDecimal = true

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Delete -> delete()
            is CalculatorAction.Clear -> clear()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun enterNumber(number: Int) {
        val currentInput = _calculatorState.value.input
        _calculatorState.value = _calculatorState.value.copy(
            input = currentInput + number.toString()
        )
        canAddOperation = true
    }

    private fun delete() {
        val currentInput = _calculatorState.value.input
        if (currentInput.isNotEmpty()) {
            _calculatorState.value = _calculatorState.value.copy(
                input = currentInput.dropLast(1)
            )
        }

        // Reset flags after deleting
        val lastChar = currentInput.lastOrNull()
        if (lastChar?.isDigit() == true) {
            canAddOperation = true
        } else {
            canAddOperation = false
        }
        canAddDecimal = !currentInput.contains(".")
    }

    private fun clear() {
        _calculatorState.value = CalculatorState()
        canAddOperation = false
        canAddDecimal = true
    }

    private fun enterOperation(operation: String) {
        if (canAddOperation) {
            val currentInput = _calculatorState.value.input
            _calculatorState.value = _calculatorState.value.copy(
                input = currentInput + operation
            )
            canAddOperation = false
            canAddDecimal = true
        }
    }

    private fun enterDecimal() {
        val currentInput = _calculatorState.value.input
        // Only add decimal if we don't already have one in the current number segment
        if (canAddDecimal && (currentInput.isEmpty() || !currentInput.split("+", "-", "*", "/").last().contains("."))) {
            _calculatorState.value = _calculatorState.value.copy(
                input = currentInput + "."
            )
            canAddDecimal = false
        }
    }

    private fun calculate() {
        val input = _calculatorState.value.input
        if (!canAddOperation || input.isEmpty()) {
            return // Don't calculate if the input ends with an operation
        }

        val result = try {
            val expression = ExpressionParser.parseExpression(input)
            expression.toString()
        } catch (e: Exception) {
            "Error"
        }

        _calculatorState.value = _calculatorState.value.copy(
            result = result
        )
    }
}