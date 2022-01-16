package com.ddona.jetpack.network

import com.ddona.jetpack.model.PassengerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PassengerApi {

    @GET("passenger")
    suspend fun getPassengerData(
        @Query("page") page: Int,
        @Query("size") size: Int = 10
    ): PassengerResponse
}