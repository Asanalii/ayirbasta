package com.example.ayirbasta.data.network

import com.example.ayirbasta.data.DTO.CreateItemParam
import com.example.ayirbasta.data.DTO.SignInParam
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface MainApi {
    @GET("healthcheck")
    suspend fun getHealthcheck(): Response<HealthcheckResponse>

    @POST("users/sign-in")
    suspend fun signIn(@Body request: SignInParam): Response<SignInResponse>

    @Multipart
    @POST("items")
    suspend fun createItem(
        @Part image: MultipartBody.Part,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
    ): Response<CreateItemResponse>
}