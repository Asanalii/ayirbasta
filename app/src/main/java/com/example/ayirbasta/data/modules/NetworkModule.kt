package com.example.ayirbasta.data.modules

import com.example.ayirbasta.data.network.MainApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
//    fun mainUrl() = "http://192.168.142.210:8080/v1/"
    fun mainUrl() = "http://192.168.0.13:8080/v1/"



    @Provides
    @Singleton
    fun getMainRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getInterceptors())
            .build()
    }

    @Provides
    fun getMainApi(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi:: class.java)
    }

    @Provides
    fun getInterceptors(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(KeyInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()
    }
}

class KeyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url
            .newBuilder()
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }

}