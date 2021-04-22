package com.learning.financingcalculator.model

class CalculateResult {

    fun calculate(data: FinancingFormData) : ResultValues {
        val financingValue = data.originalValue - data.inputValue
        val installments = financingValue / data.installments
        val installmentsWithInterest = installments + (data.originalValue * data.interestPercentByMonth / 100)
        val total = (installmentsWithInterest * data.installments) + data.inputValue
        val diff = total - data.originalValue

        return ResultValues(
            original = data.originalValue,
            input = data.inputValue,
            financing = financingValue,
            installments = installmentsWithInterest,
            diff = diff,
            total = total
        )
    }
}