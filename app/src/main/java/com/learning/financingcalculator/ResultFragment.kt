package com.learning.financingcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.learning.financingcalculator.databinding.FragmentResultBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.text.NumberFormat

class ResultFragment : Fragment() {

    private var binding: FragmentResultBinding? = null
    private val viewModel by sharedViewModel<CalculatorViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.results.observe(viewLifecycleOwner, Observer { showResults(it) })
        binding?.buttonCalculate?.visibility = View.GONE
    }

    private fun showResults(result: ResultValues) {
        val currencyFormatter = NumberFormat.getCurrencyInstance()
        binding?.apply {
            originalValue.text = currencyFormatter.format(result.original)
            totalValue.text = currencyFormatter.format(result.total)
            installmentValue.text = currencyFormatter.format(result.installments)
            financingInput.text = currencyFormatter.format(result.input)
            financingValue.text = currencyFormatter.format(result.financing)
            diff.text = currencyFormatter.format(result.diff)
            buttonCalculate.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}