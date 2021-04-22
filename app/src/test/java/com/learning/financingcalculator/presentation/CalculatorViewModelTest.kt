package com.learning.financingcalculator.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.learning.financingcalculator.CoroutineTestRule
import com.learning.financingcalculator.model.CalculateResult
import com.learning.financingcalculator.model.FinancingFormData
import com.learning.financingcalculator.model.ResultValues
import io.mockk.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorViewModelTest {

    private lateinit var viewModel: CalculatorViewModel
    private lateinit var useCase: CalculateResult

    @get:Rule
    val liveDataRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesRule = CoroutineTestRule()

    @Before
    fun before() {
        useCase = mockk()
        viewModel = CalculatorViewModel(useCase)
    }

    @Test
    fun `test result calculation`() {
        val result = ResultValues(
            original = 0.0,
            financing = 0.0,
            installments = 0.0,
            total = 0.0,
            diff = 0.0,
            input = 0.0
        )
        val input = FinancingFormData(
            originalValue = 0.0,
            installments = 0,
            interestPercentByMonth = 0.0,
            inputValue = 0.0
        )
        every { useCase.calculate(input) } returns result

        viewModel.onCalculateClicked(input)

        assertEquals(result, viewModel.results.value)
        verify { useCase.calculate(input) }
    }
}