package com.example.ayirbasta.data.network

import com.google.gson.annotations.SerializedName

data class SignInResponse (
    @SerializedName("authentication_token")
    val authenticationToken: String? = null
)