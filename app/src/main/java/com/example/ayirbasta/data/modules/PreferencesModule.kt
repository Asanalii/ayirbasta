package com.example.ayirbasta.data.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.app_study_hilt.data.preferences.SharedPreferencesUtils
import com.example.app_study_hilt.data.preferences.SharedPreferencesUtilsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("My shared prefernces", AppCompatActivity.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesUtils(sharedPreferences: SharedPreferences): SharedPreferencesUtils =
        SharedPreferencesUtilsImpl(sharedPreferences)
}