package com.example.ayirbasta.pages.login.api

import com.example.ayirbasta.data.DTO.SignInParam
import com.example.ayirbasta.data.repositories.MainRepository


interface SignInUseCase {
    suspend fun execute(email: String, password: String): SignInResponse?
}


class SignInInteraction(
    private val repo: MainRepository
) : SignInUseCase {
    override suspend fun execute(email: String, password: String): SignInResponse? {
        return repo.signIn(SignInParam(email, password))
    }
}

