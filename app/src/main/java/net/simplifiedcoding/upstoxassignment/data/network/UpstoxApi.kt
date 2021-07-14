package net.simplifiedcoding.upstoxassignment.data.network

import net.simplifiedcoding.upstoxassignment.data.HoldingsResponse
import retrofit2.http.GET

interface UpstoxApi {

    @GET("6d0ad460-f600-47a7-b973-4a779ebbaeaf")
    suspend fun getHoldingsResponse(): HoldingsResponse

}