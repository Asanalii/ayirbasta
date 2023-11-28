package com.example.ayirbasta.data.network

import com.google.gson.annotations.SerializedName

data class HealthcheckResponse(
    val status: String? = null,
    @SerializedName("system_info")
    val systemInfo: SystemInfo? = null
)

data class SystemInfo(
    val environment: String? = null,
    val version: String? = null
)

data class MainApiError(
    val error: MainApiErrorData? = null
)

data class MainApiErrorData(
    val code: Int? = null,
    val message: String? = null
)