package com.example.ayirbasta.data.use_cases

import com.example.ayirbasta.data.network.HealthcheckResponse
import com.example.ayirbasta.data.repositories.MainRepository

interface GetHealthcheckUseCase {
    suspend fun execute(): HealthcheckResponse?
}

class GetHealthcheckInteraction(
    private val repo: MainRepository
): GetHealthcheckUseCase {
    override suspend fun execute(): HealthcheckResponse? {
        return repo.getHealthcheck()
    }
}

