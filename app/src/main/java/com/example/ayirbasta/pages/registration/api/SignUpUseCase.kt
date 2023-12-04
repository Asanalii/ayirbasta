package com.example.ayirbasta.pages.registration.api

import com.example.ayirbasta.data.network.SignUpResponse
import com.example.ayirbasta.data.repositories.MainRepository

interface SignUpUseCase {
    suspend fun execute(
        firstname: String,
        lastname: String,
        email: String,
        password: String
    ): SignUpResponse?
}


class SignUpInteraction(
    private val repo: MainRepository
) : SignUpUseCase {
    override suspend fun execute(
        firstname: String,
        lastname: String,
        email: String,
        password: String
    ): SignUpResponse? {
        return repo.signUp(SignUpParam(firstname, lastname, email, password))
    }
}