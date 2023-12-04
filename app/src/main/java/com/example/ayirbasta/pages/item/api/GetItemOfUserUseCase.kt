package com.example.ayirbasta.pages.item.api

import com.example.ayirbasta.data.repositories.MainRepository

interface GetItemOfUserUseCase {
    suspend fun execute(): ItemsOfUserResponse?
}

class GetItemOfUserInteraction(
    private val repo: MainRepository
): GetItemOfUserUseCase {
    override suspend fun execute(): ItemsOfUserResponse? {
        return repo.getItemsOfUser()
    }
}
