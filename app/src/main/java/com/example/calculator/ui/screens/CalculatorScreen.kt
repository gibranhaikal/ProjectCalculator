package com.example.calculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.components.CalculatorButton
import com.example.calculator.ui.components.CalculatorDisplay
import com.example.calculator.viewmodel.CalculatorAction
import com.example.calculator.viewmodel.CalculatorViewModel

@Composable
fun CalculatorApp() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.calculatorState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        CalculatorDisplay(
            input = state.input,
            result = state.result,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Row 1: Clear, Delete, Divide
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "C",
                onClick = { viewModel.onAction(CalculatorAction.Clear) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                backgroundColor = Color.LightGray
            )
            CalculatorButton(
                symbol = "⌫",
                onClick = { viewModel.onAction(CalculatorAction.Delete) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                backgroundColor = Color.LightGray
            )
            CalculatorButton(
                symbol = "÷",
                onClick = { viewModel.onAction(CalculatorAction.Operation("/")) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                backgroundColor = Color(0xFFFF9800)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Row 2: 7, 8, 9, Multiply
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "7",
                onClick = { viewModel.onAction(CalculatorAction.Number(7)) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            CalculatorButton(
                symbol = "8",
                onClick = { viewModel.onAction(CalculatorAction.Number(8)) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            CalculatorButton(
                symbol = "9",
                onClick = { viewModel.onAction(CalculatorAction.Number(9)) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            CalculatorButton(
                symbol = "×",
                onClick = { viewModel.onAction(CalculatorAction.Operation("*")) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                backgroundColor = Color(0xFFFF9800)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Row 3: 4, 5, 6, Subtract
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "4",
                onClick = { viewModel.onAction(CalculatorAction.Number(4)) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            CalculatorButton(
                symbol = "5",
                onClick = { viewModel.onAction(CalculatorAction.Number(5)) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            CalculatorButton(
                symbol = "6",
                onClick = { viewModel.onAction(CalculatorAction.Number(6)) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            CalculatorButton(
                symbol = "-",
                onClick = { viewModel.onAction(CalculatorAction.Operation("-")) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                backgroundColor = Color(0xFFFF9800)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Row 4: 1, 2, 3, Add
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "1",
                onClick = { viewModel.onAction(CalculatorAction.Number(1)) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            CalculatorButton(
                symbol = "2",
                onClick = { viewModel.onAction(CalculatorAction.Number(2)) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            CalculatorButton(
                symbol = "3",
                onClick = { viewModel.onAction(CalculatorAction.Number(3)) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            CalculatorButton(
                symbol = "+",
                onClick = { viewModel.onAction(CalculatorAction.Operation("+")) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                backgroundColor = Color(0xFFFF9800)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Row 5: 0, ., =
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "0",
                onClick = { viewModel.onAction(CalculatorAction.Number(0)) },
                modifier = Modifier
                    .weight(2f)
                    .aspectRatio(2f)
            )
            CalculatorButton(
                symbol = ".",
                onClick = { viewModel.onAction(CalculatorAction.Decimal) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            )
            CalculatorButton(
                symbol = "=",
                onClick = { viewModel.onAction(CalculatorAction.Calculate) },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                backgroundColor = Color(0xFFFF9800)
            )
        }
    }
}