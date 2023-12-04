package com.example.ayirbasta.pages.login.api

import com.google.gson.annotations.SerializedName

data class SignInResponse (
    @SerializedName("authentication_token")
    val authenticationToken: String? = null
)