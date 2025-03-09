package com.example.calculator.util

object ExpressionParser {
    fun parseExpression(expression: String): Double {
        return evaluateExpression(tokenize(expression))
    }

    private fun tokenize(expression: String): List<String> {
        val result = mutableListOf<String>()
        var currentNumber = StringBuilder()

        for (char in expression) {
            if (char.isDigit() || char == '.') {
                currentNumber.append(char)
            } else if (char in setOf('+', '-', '*', '/')) {
                if (currentNumber.isNotEmpty()) {
                    result.add(currentNumber.toString())
                    currentNumber.clear()
                }
                result.add(char.toString())
            }
        }

        if (currentNumber.isNotEmpty()) {
            result.add(currentNumber.toString())
        }

        return result
    }

    private fun evaluateExpression(tokens: List<String>): Double {
        // First handle multiplication and division
        val pass1 = mutableListOf<String>()
        var i = 0

        while (i < tokens.size) {
            if (i + 2 < tokens.size && tokens[i+1] in setOf("*", "/")) {
                val left = tokens[i].toDouble()
                val operator = tokens[i+1]
                val right = tokens[i+2].toDouble()

                val result = when (operator) {
                    "*" -> left * right
                    "/" -> if (right != 0.0) left / right else Double.POSITIVE_INFINITY
                    else -> throw IllegalArgumentException("Unknown operator: $operator")
                }
                pass1.add(result.toString())
                i += 3
            } else {
                pass1.add(tokens[i])
                i++
            }
        }

        // Then handle addition and subtraction
        var result = pass1.getOrNull(0)?.toDoubleOrNull() ?: 0.0
        i = 1

        while (i < pass1.size) {
            if (i + 1 < pass1.size && pass1[i] in setOf("+", "-")) {
                val operator = pass1[i]
                val right = pass1[i+1].toDouble()

                result = when (operator) {
                    "+" -> result + right
                    "-" -> result - right
                    else -> throw IllegalArgumentException("Unknown operator: $operator")
                }
                i += 2
            } else {
                i++
            }
        }

        return result
    }
}