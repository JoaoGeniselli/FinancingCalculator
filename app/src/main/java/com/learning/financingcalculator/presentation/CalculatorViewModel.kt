package com.learning.financingcalculator.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.financingcalculator.model.CalculateResult
import com.learning.financingcalculator.toolbox.Event
import com.learning.financingcalculator.model.FinancingFormData
import com.learning.financingcalculator.model.ResultValues
import kotlinx.coroutines.launch

class CalculatorViewModel(
    private val calculateResult: CalculateResult
) : ViewModel() {

    private val _results = MutableLiveData<ResultValues>()
    val results: LiveData<ResultValues> get() = _results

    private val _copySuccess = MutableLiveData<Event<Unit>>()
    val copySuccess: LiveData<Event<Unit>> get() = _copySuccess

    private val _reset = MutableLiveData<Event<Unit>>()
    val reset: LiveData<Event<Unit>> get() = _reset

    fun onResetClicked() {

    }

    fun onCalculateClicked(data: FinancingFormData) {
        viewModelScope.launch {
            _results.value = calculateResult.calculate(data)
        }
    }

    fun onCopyClicked() {

    }
}