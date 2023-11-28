package com.example.ayirbasta.data.network

import retrofit2.Response
import retrofit2.http.GET

interface MainApi {
    @GET("healthcheck.json")
    suspend fun getHealthcheck(): Response<HealthcheckResponse>

}