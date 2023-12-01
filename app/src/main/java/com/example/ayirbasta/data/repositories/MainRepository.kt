package com.example.ayirbasta.data.repositories

import com.example.ayirbasta.data.DTO.CreateItemParam
import com.example.ayirbasta.data.DTO.SignInParam
import com.example.ayirbasta.data.network.CreateItemResponse
import com.example.ayirbasta.data.network.HealthcheckResponse
import com.example.ayirbasta.data.network.MainApi
import com.example.ayirbasta.data.network.MainApiError
import com.example.ayirbasta.data.network.SignInResponse
import com.google.gson.Gson
import okhttp3.ResponseBody
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
interface MainRepository {
    suspend fun getHealthcheck(): HealthcheckResponse?
    suspend fun signIn(body: SignInParam): SignInResponse?

    suspend fun createItem(body: CreateItemParam): CreateItemResponse?
}

class MainRepositoryImpl @Inject constructor(
    private val api: MainApi
): MainRepository {
    override suspend fun getHealthcheck(): HealthcheckResponse? {
        val response = api.getHealthcheck()


        if (response.isSuccessful) return response.body()

        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun signIn(body: SignInParam): SignInResponse? {
        val response = api.signIn(body)

        if (response.isSuccessful) return response.body()

        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun createItem(body: CreateItemParam): CreateItemResponse? {
        val response = api.createItem(body)

        if(response.isSuccessful) return response.body()

        else throw Exception(response.errorBody().getErrorMessage())
    }


}

fun ResponseBody?.getErrorMessage():String? {
    return try{
        Gson().fromJson(this?.charStream(), MainApiError::class.java)?.error?.message
    } catch (e: Exception){
        e.message.orEmpty()
    }
}