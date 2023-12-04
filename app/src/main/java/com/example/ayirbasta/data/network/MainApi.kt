package com.example.ayirbasta.data.network

import com.example.ayirbasta.data.DTO.SignInParam
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse
import com.example.ayirbasta.pages.login.api.SignInResponse
import com.example.ayirbasta.pages.registration.api.SignUpParam
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface MainApi {
    @GET("healthcheck")
    suspend fun getHealthcheck(): Response<HealthcheckResponse>

    @GET("user/items")
    suspend fun getItemsOfUser(@Header("Authorization") authHeader: String): Response<ItemsOfUserResponse>
    @POST("users/sign-in")
    suspend fun signIn(@Body request: SignInParam): Response<SignInResponse>

    @POST("users/sign-up")
    suspend fun signUp(@Body request: SignUpParam): Response<SignUpResponse>



    @Multipart
    @POST("items")
    suspend fun createItem(
        @Part image: MultipartBody.Part,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
    ): Response<CreateItemResponse>
}