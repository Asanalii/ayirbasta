package com.example.ayirbasta.pages.item.api

import com.example.ayirbasta.data.repositories.MainRepository

interface GetItemByIdUseCase {
    suspend fun execute(id: Int): ItemByIdResponse?
}

class GetItemByIdInteraction(
    private val repo: MainRepository
) : GetItemByIdUseCase {
    override suspend fun execute(id: Int): ItemByIdResponse? {
        return repo.getItemById(id)
    }
}
