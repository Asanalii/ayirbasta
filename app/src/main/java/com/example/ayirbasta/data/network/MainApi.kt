package com.example.ayirbasta.data.network

import com.example.ayirbasta.data.DTO.SignInParam
import com.example.ayirbasta.pages.trades.api.AvailableTradesResponse
import com.example.ayirbasta.pages.item.api.AllItemsResponse
import com.example.ayirbasta.pages.item.api.ItemByIdResponse
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse
import com.example.ayirbasta.pages.login.api.SignInResponse
import com.example.ayirbasta.pages.registration.api.SignUpParam
import com.example.ayirbasta.pages.trades.api.CreateTradeParam
import com.example.ayirbasta.pages.trades.api.CreateTradeResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface MainApi {
    @GET("healthcheck")
    suspend fun getHealthcheck(): Response<HealthcheckResponse>

    @GET("items")
    suspend fun getAllItems(): Response<AllItemsResponse>

    @GET("item/{id}")
    suspend fun getItemById(@Path("id") id: Int): Response<ItemByIdResponse>

    @GET("user/items")
    suspend fun getItemsOfUser(@Header("Authorization") authHeader: String): Response<ItemsOfUserResponse>

    @GET("user/trades")
    suspend fun getAvailableTrades(@Header("Authorization") authHeader: String): Response<AvailableTradesResponse>

    @POST("users/sign-in")
    suspend fun signIn(@Body request: SignInParam): Response<SignInResponse>

    @POST("users/sign-up")
    suspend fun signUp(@Body request: SignUpParam): Response<SignUpResponse>

    @POST("trades")
    suspend fun createTrade(@Body request: CreateTradeParam): Response<CreateTradeResponse>

    @Multipart
    @POST("items")
    suspend fun createItem(
        @Header("Authorization") authHeader: String,
        @Part images: MultipartBody.Part,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
    ): Response<CreateItemResponse>
}