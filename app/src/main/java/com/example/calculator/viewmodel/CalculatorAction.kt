package com.example.calculator.viewmodel

sealed class CalculatorAction {
    data class Number(val number: Int) : CalculatorAction()
    object Clear : CalculatorAction()
    object Delete : CalculatorAction()
    data class Operation(val operation: String) : CalculatorAction()
    object Decimal : CalculatorAction()
    object Calculate : CalculatorAction()
}