package com.example.ayirbasta.pages.trades.api

import com.example.ayirbasta.data.repositories.MainRepository

interface CreateTradeUseCase {

    suspend fun execute(
        giver: Int,
        receiver: Int
    ): CreateTradeResponse?
}

class CreateTradeInteraction(
    private val repo: MainRepository
): CreateTradeUseCase {
    override suspend fun execute(
        giver: Int,
        receiver: Int
    ): CreateTradeResponse? {
        return repo.createTrade(CreateTradeParam(giver,receiver))
    }
}