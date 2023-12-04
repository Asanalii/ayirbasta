package com.example.ayirbasta.data.network

import com.google.gson.annotations.SerializedName

data class SignUpResponse (
    val user: User? = null
)

data class User (
    val firstname: String? = null,
    val lastname: String? = null,
    val email: String? = null,
//    val firstname: String? = null,
)