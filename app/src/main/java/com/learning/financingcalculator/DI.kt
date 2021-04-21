package com.learning.financingcalculator

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule by lazy {
    module {
        viewModel { CalculatorViewModel() }
    }
}