package com.example.ayirbasta.pages.item.api

import com.example.ayirbasta.data.repositories.MainRepository

interface GetAllItemsUseCase {
    suspend fun execute(): AllItemsResponse?
}

class GetAllItemsInteraction(
    private val repo: MainRepository
) : GetAllItemsUseCase {
    override suspend fun execute(): AllItemsResponse? {
        return repo.getAllItems()
    }
}
