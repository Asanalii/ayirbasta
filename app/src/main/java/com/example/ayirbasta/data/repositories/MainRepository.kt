package com.example.ayirbasta.data.repositories

import com.example.app_study_hilt.data.preferences.Preferences
import com.example.app_study_hilt.data.preferences.SharedPreferencesUtils
import com.example.ayirbasta.data.DTO.CreateItemParam
import com.example.ayirbasta.data.DTO.SignInParam
import com.example.ayirbasta.data.network.CreateItemResponse
import com.example.ayirbasta.data.network.HealthcheckResponse
import com.example.ayirbasta.data.network.MainApi
import com.example.ayirbasta.data.network.MainApiError
import com.example.ayirbasta.pages.login.api.SignInResponse
import com.example.ayirbasta.data.network.SignUpResponse
import com.example.ayirbasta.pages.item.api.ItemByIdResponse
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse
import com.example.ayirbasta.pages.registration.api.SignUpParam
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import java.lang.Exception
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
interface MainRepository {
    suspend fun getHealthcheck(): HealthcheckResponse?

    suspend fun getItemsOfUser(): ItemsOfUserResponse?

    suspend fun getItemById(id: Int): ItemByIdResponse?

    suspend fun signIn(body: SignInParam): SignInResponse?
    suspend fun signUp(body: SignUpParam): SignUpResponse?
    suspend fun createItem(body: CreateItemParam): CreateItemResponse?
}

class MainRepositoryImpl @Inject constructor(
    private val api: MainApi,
    private val preferences: SharedPreferencesUtils
) : MainRepository {
    override suspend fun getHealthcheck(): HealthcheckResponse? {
        val response = api.getHealthcheck()


        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun signUp(body: SignUpParam): SignUpResponse? {
        val response = api.signUp(body)

        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())

    }

    override suspend fun signIn(body: SignInParam): SignInResponse? {
        val response = api.signIn(body)

        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun createItem(body: CreateItemParam): CreateItemResponse? {
        val requestFile =
            body.images.toRequestBody(
                "multipart/form-data".toMediaTypeOrNull(),
                0,
                body.images.size
            )
        val requestImagesBody =
            MultipartBody.Part.createFormData("images", UUID.randomUUID().toString(), requestFile)

        val response = api.createItem(
            getAuthHeader(),

            requestImagesBody,
            body.name.toRequestBody("name".toMediaTypeOrNull()),
            body.description.toRequestBody("description".toMediaTypeOrNull())
        )

        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun getItemsOfUser(): ItemsOfUserResponse? {
        val response = api.getItemsOfUser(getAuthHeader())

        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun getItemById(id: Int): ItemByIdResponse? {
        val response = api.getItemById(id)

        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

    private fun getAuthHeader(): String {
        val token = preferences.getToken(Preferences.ACCESS_TOKEN)
        return "Bearer $token"
    }

}

fun ResponseBody?.getErrorMessage(): String? {
    return try {
        Gson().fromJson(this?.charStream(), MainApiError::class.java)?.error?.message
    } catch (e: Exception) {
        e.message.orEmpty()
    }
}