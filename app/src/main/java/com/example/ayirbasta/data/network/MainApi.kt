package com.example.ayirbasta.data.network

import com.example.ayirbasta.data.DTO.CreateItemParam
import com.example.ayirbasta.data.DTO.SignInParam
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MainApi {
    @GET("healthcheck")
    suspend fun getHealthcheck(): Response<HealthcheckResponse>

    @POST("users/sign-in")
    suspend fun signIn(@Body request: SignInParam): Response<SignInResponse>

    @POST("items")
    suspend fun createItem(@Body request: CreateItemParam): Response<CreateItemResponse>
}