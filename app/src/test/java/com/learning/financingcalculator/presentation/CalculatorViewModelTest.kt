package com.learning.financingcalculator.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.learning.financingcalculator.CoroutineTestRule
import com.learning.financingcalculator.model.CalculateResult
import com.learning.financingcalculator.model.FinancingFormData
import com.learning.financingcalculator.model.ResultValues
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
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
        // Given
        val input = mockInput()
        val result = mockResult()
        every { useCase.calculate(input) } returns result

        // When
        viewModel.onCalculateClicked(input)

        // Then
        assertEquals(result, viewModel.results.value)
        verify { useCase.calculate(input) }
    }

    private fun mockInput() = FinancingFormData(
        originalValue = 0.0,
        installments = 0,
        interestPercentByMonth = 0.0,
        inputValue = 0.0
    )

    private fun mockResult() = ResultValues(
        original = 0.0,
        financing = 0.0,
        installments = 0.0,
        total = 0.0,
        diff = 0.0,
        input = 0.0
    )
}