package com.learning.financingcalculator.model

data class ResultValues(
    val original: Double,
    val input: Double,
    val installments: Double,
    val financing: Double,
    val total: Double,
    val diff: Double
)