package net.simplifiedcoding.upstoxassignment.data.repository

import net.simplifiedcoding.upstoxassignment.data.network.SafeApiCall
import net.simplifiedcoding.upstoxassignment.data.network.UpstoxApi
import javax.inject.Inject

class HoldingsRepository @Inject constructor(
    private val api: UpstoxApi
) : SafeApiCall {
    suspend fun getHoldings() = safeApiCall { api.getHoldingsResponse() }
}