package com.example.ayirbasta.data.use_cases

import com.example.ayirbasta.data.DTO.SignInParam
import com.example.ayirbasta.data.network.SignInResponse
import com.example.ayirbasta.data.repositories.MainRepository
import okhttp3.RequestBody

interface SignInUseCase {
    suspend fun execute(email: String, password: String): SignInResponse?
}


class SignInInteraction(
    private val repo: MainRepository
): SignInUseCase {
    override suspend fun execute(email: String, password: String): SignInResponse? {
        return repo.signIn(SignInParam(email,password))
    }
}

