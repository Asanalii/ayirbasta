package com.example.ayirbasta.data.modules

import com.example.ayirbasta.data.repositories.MainRepository
import com.example.ayirbasta.data.use_cases.GetHealthcheckInteraction
import com.example.ayirbasta.data.use_cases.GetHealthcheckUseCase
import com.example.ayirbasta.data.use_cases.SignInInteraction
import com.example.ayirbasta.data.use_cases.SignInUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideGetHealthcheck(repo: MainRepository): GetHealthcheckUseCase =
        GetHealthcheckInteraction(repo)

    @Provides
    fun provideSignIn(repo: MainRepository): SignInUseCase =
        SignInInteraction(repo)


}