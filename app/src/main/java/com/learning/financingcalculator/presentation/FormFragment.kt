package com.learning.financingcalculator.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.learning.financingcalculator.model.FinancingFormData
import com.learning.financingcalculator.databinding.FragmentFormBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FormFragment : Fragment(), TextWatcher {

    private var binding: FragmentFormBinding? = null
    private val viewModel by sharedViewModel<CalculatorViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            buttonCalculate.apply {
                setOnClickListener { validateForm() }
//                isEnabled = false
            }
            allFields.forEach {
                it.editText?.addTextChangedListener(this@FormFragment)
            }
        }
    }

    private val FragmentFormBinding.allFields: List<TextInputLayout>
        get() = listOf(inputTotal, inputInitialValue, inputInstallments, inputInterestPerMonth)

    private fun validateForm() {
        val safeBinding = binding ?: return
        val data = FinancingFormData(
            originalValue = extractValue(safeBinding.inputTotal).toDouble(),
            installments = extractValue(safeBinding.inputInstallments).toInt(),
            inputValue = extractValue(safeBinding.inputInitialValue).toDouble(),
            interestPercentByMonth = extractValue(safeBinding.inputInterestPerMonth).toDouble()
        )
        viewModel.onCalculateClicked(data)
    }

    private fun extractValue(inputLayout: TextInputLayout) =
        inputLayout.editText?.text.toString()

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.allFields?.forEach {
            it.editText?.removeTextChangedListener(this@FormFragment)
        }
        binding = null
    }

    override fun afterTextChanged(s: Editable?) = Unit

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }
}