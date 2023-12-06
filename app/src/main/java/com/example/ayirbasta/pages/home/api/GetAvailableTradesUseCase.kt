package com.example.ayirbasta.pages.home.api

import com.example.ayirbasta.data.repositories.MainRepository
import com.example.ayirbasta.pages.item.api.GetItemOfUserUseCase
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse

interface GetAvailableTradesUseCase {
    suspend fun execute(): AvailableTradesResponse?
}

class GetAvailableTradesInteraction(
    private val repo: MainRepository
): GetAvailableTradesUseCase {
    override suspend fun execute(): AvailableTradesResponse? {
//        return repo.getItemsOfUser()
        return repo.getAvailableTrades()

    }
}
