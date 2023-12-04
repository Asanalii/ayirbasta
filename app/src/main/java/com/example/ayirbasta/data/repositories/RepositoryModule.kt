package com.example.ayirbasta.data.repositories

import com.example.app_study_hilt.data.preferences.SharedPreferencesUtils
import com.example.ayirbasta.data.network.MainApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(api: MainApi, preferences: SharedPreferencesUtils): MainRepository =
        MainRepositoryImpl(api, preferences)

}