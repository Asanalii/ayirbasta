package com.example.ayirbasta.pages.trades.api

import com.example.ayirbasta.data.repositories.MainRepository

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
