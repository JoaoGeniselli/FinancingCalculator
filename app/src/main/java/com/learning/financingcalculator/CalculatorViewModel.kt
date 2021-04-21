package com.learning.financingcalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val _results = MutableLiveData<ResultValues>()
    val results: LiveData<ResultValues> get() = _results

    private val _copySuccess = MutableLiveData<Event<Unit>>()
    val copySuccess: LiveData<Event<Unit>> get() = _copySuccess

    private val _reset = MutableLiveData<Event<Unit>>()
    val reset: LiveData<Event<Unit>> get() = _reset

    fun onResetClicked() {

    }

    fun onCalculateClicked(data: FinancingFormData) {
        val financingValue = data.originalValue - data.inputValue
        val installments = financingValue / data.installments
        val installmentsWithInterest = installments + installments * data.interestPercentByMonth
        val total = (installmentsWithInterest * data.installments * data.interestPercentByMonth) + data.inputValue
        val diff = total - data.originalValue

        _results.value = ResultValues(
            original = data.originalValue,
            input = data.inputValue,
            financing = financingValue,
            installments = installments,
            diff = diff,
            total = total
        )
    }

    fun onCopyClicked() {

    }
}