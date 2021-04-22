package com.learning.financingcalculator.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learning.financingcalculator.toolbox.Event
import com.learning.financingcalculator.model.FinancingFormData
import com.learning.financingcalculator.model.ResultValues

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
        val installmentsWithInterest = installments + (financingValue * data.interestPercentByMonth / 100)
        val total = (installmentsWithInterest * data.installments) + data.inputValue
        val diff = total - data.originalValue

        _results.value = ResultValues(
            original = data.originalValue,
            input = data.inputValue,
            financing = financingValue,
            installments = installmentsWithInterest,
            diff = diff,
            total = total
        )
    }

    fun onCopyClicked() {

    }
}