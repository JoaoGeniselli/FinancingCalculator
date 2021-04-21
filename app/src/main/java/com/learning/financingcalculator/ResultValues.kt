package com.learning.financingcalculator

data class ResultValues(
    val original: Double,
    val input: Double,
    val installments: Double,
    val financing: Double,
    val total: Double,
    val diff: Double
)