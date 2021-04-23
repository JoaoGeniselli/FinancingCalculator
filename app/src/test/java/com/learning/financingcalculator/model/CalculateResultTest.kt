package com.learning.financingcalculator.model

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculateResultTest {

    private lateinit var calculateResult: CalculateResult

    @Before
    fun before() {
        calculateResult = CalculateResult()
    }

    @Test
    fun `test results`() {
        // Given
        val data = makeFormData(input = 0.0)

        // When
        val result = calculateResult.calculate(data)

        // Then
        assertEquals(100000.0, result.original)
        assertEquals(0.0, result.input)
        assertEquals(100000.0, result.financing)
        assertEquals(2000.0, result.installments)
        assertEquals(200000.0, result.total)
        assertEquals(100000.0, result.diff)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `test validation`() {
        // Given
        val data = makeFormData(input = 120000.0)

        // When
        calculateResult.calculate(data)

        // Then: Exception
    }

    private fun makeFormData(input: Double) = FinancingFormData(
        originalValue = 100000.0,
        inputValue = input,
        installments = 100,
        interestPercentByMonth = 1.0
    )
}