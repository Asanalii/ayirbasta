package com.example.ayirbasta.data.use_cases

import com.example.ayirbasta.data.DTO.CreateItemParam
import com.example.ayirbasta.data.network.CreateItemResponse
import com.example.ayirbasta.data.repositories.MainRepository

interface CreateItemUseCase {
    suspend fun execute(
        name: String,
        description: String,
//        images: List<String>
    ): CreateItemResponse?
}

class CreateItemInteraction(
    private val repo: MainRepository
) : CreateItemUseCase {
    override suspend fun execute(
        name: String,
        description: String,
//        images: List<String>
    ): CreateItemResponse? {
        return repo.createItem(CreateItemParam(name,description))
    }
}