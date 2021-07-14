package net.simplifiedcoding.upstoxassignment.ui.holdings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.simplifiedcoding.upstoxassignment.data.HoldingsResponse
import net.simplifiedcoding.upstoxassignment.data.network.Resource
import net.simplifiedcoding.upstoxassignment.data.repository.HoldingsRepository
import javax.inject.Inject

@HiltViewModel
class HoldingsFragmentViewModel @Inject constructor(
    private val repository: HoldingsRepository
) : ViewModel() {

    private val _holdingsResponse = MutableLiveData<Resource<HoldingsResponse>>()
    val holdingsResponse: LiveData<Resource<HoldingsResponse>>
        get() = _holdingsResponse

    init {
        getHoldings()
    }

    private fun getHoldings() = viewModelScope.launch {
        _holdingsResponse.value = repository.getHoldings()
    }
}