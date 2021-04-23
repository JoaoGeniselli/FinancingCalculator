package com.learning.financingcalculator.model

import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class CalculateResultTest {

    private lateinit var calculateResult: CalculateResult

    @Before
    fun before() {
        calculateResult = CalculateResult()
    }

    @Test
    fun `test results`() {
        val data = FinancingFormData(
            originalValue = 100000.0,
            inputValue = 0.0,
            installments = 100,
            interestPercentByMonth = 1.0
        )

        val result = calculateResult.calculate(data)

        assertEquals(100000.0, result.original)
        assertEquals(0.0, result.input)
        assertEquals(100000.0, result.financing)
        assertEquals(2000.0, result.installments)
        assertEquals(200000.0, result.total)
        assertEquals(100000.0, result.diff)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `test validation`() {
        val data = FinancingFormData(
            originalValue = 100000.0,
            inputValue = 120000.0,
            installments = 100,
            interestPercentByMonth = 1.0
        )
        calculateResult.calculate(data)
    }
}