package net.simplifiedcoding.upstoxassignment.ui.holdings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.simplifiedcoding.upstoxassignment.R
import net.simplifiedcoding.upstoxassignment.data.network.Resource
import net.simplifiedcoding.upstoxassignment.databinding.FragmentHoldingsBinding

@AndroidEntryPoint
class HoldingsFragment : Fragment(R.layout.fragment_holdings) {

    private lateinit var binding: FragmentHoldingsBinding
    private val viewModel by viewModels<HoldingsFragmentViewModel>()
    private val holdingsAdapter = HoldingsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHoldingsBinding.bind(view)
        binding.recyclerView.adapter = holdingsAdapter
        viewModel.holdingsResponse.observe(viewLifecycleOwner) { data ->
            when (data) {
                is Resource.Failure -> {

                }
                Resource.Loading -> {

                }
                is Resource.Success -> {
                    holdingsAdapter.items = data.value.data
                }
            }
        }
    }
}