package com.example.ayirbasta.data.modules

import com.example.ayirbasta.data.repositories.MainRepository
import com.example.ayirbasta.data.use_cases.CreateItemInteraction
import com.example.ayirbasta.data.use_cases.CreateItemUseCase
import com.example.ayirbasta.data.use_cases.GetHealthcheckInteraction
import com.example.ayirbasta.data.use_cases.GetHealthcheckUseCase
import com.example.ayirbasta.pages.home.api.GetAvailableTradesInteraction
import com.example.ayirbasta.pages.home.api.GetAvailableTradesUseCase
import com.example.ayirbasta.pages.item.api.GetAllItemsInteraction
import com.example.ayirbasta.pages.item.api.GetAllItemsUseCase
import com.example.ayirbasta.pages.item.api.GetItemByIdInteraction
import com.example.ayirbasta.pages.item.api.GetItemByIdUseCase
import com.example.ayirbasta.pages.item.api.GetItemOfUserInteraction
import com.example.ayirbasta.pages.item.api.GetItemOfUserUseCase
import com.example.ayirbasta.pages.login.api.SignInInteraction
import com.example.ayirbasta.pages.login.api.SignInUseCase
import com.example.ayirbasta.pages.registration.api.SignUpInteraction
import com.example.ayirbasta.pages.registration.api.SignUpUseCase
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

    @Provides
    fun createItem(repo: MainRepository): CreateItemUseCase =
        CreateItemInteraction(repo)

    @Provides
    fun provideSignUp(repo: MainRepository): SignUpUseCase =
        SignUpInteraction(repo)

    @Provides
    fun provideGetItemsOfUser(repo: MainRepository): GetItemOfUserUseCase =
        GetItemOfUserInteraction(repo)

    @Provides
    fun provideGetItemById(repo: MainRepository): GetItemByIdUseCase  =
        GetItemByIdInteraction(repo)

    @Provides
    fun provideGetAvailableTrades(repo: MainRepository): GetAvailableTradesUseCase =
        GetAvailableTradesInteraction(repo)

    @Provides
    fun provideGetAllItems(repo: MainRepository): GetAllItemsUseCase =
        GetAllItemsInteraction(repo)


}