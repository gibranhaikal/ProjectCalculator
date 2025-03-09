package com.example.calculator.model


data class CalculatorState(
    val input: String = "",
    val result: String = "",
    val operation: String = ""
)