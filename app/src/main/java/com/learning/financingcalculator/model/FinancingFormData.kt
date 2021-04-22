package com.learning.financingcalculator.model

class FinancingFormData(
    val originalValue: Double,
    val inputValue: Double,
    val installments: Int,
    val interestPercentByMonth: Double
) {

    fun isValid(): Boolean {
//        if (originalValue.isNullOrZero() ||
//            inputValue.isNullOrZero() ||
//            installments.isNullOrZero() ||
//            interestPercentByMonth.isNullOrZero()
//        ) {
//            return false
//        }
//
//        if (originalValue < inputValue) {
//            return false
//        }
//

        return true
    }

    private fun Number?.isNullOrZero() = this == null || this == 0.0
}


