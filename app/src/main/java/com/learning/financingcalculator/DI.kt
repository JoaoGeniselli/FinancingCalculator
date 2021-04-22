package com.learning.financingcalculator

import com.learning.financingcalculator.model.CalculateResult
import com.learning.financingcalculator.presentation.CalculatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule by lazy {
    module {
        single { CalculateResult() }
        viewModel { CalculatorViewModel(get()) }
    }
}