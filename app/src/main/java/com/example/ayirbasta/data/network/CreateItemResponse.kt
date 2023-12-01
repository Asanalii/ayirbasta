package com.example.ayirbasta.data.network

import com.google.gson.annotations.SerializedName

data class CreateItemResponse(
    val item: ItemInfo? = null
)

data class ItemInfo(
    val id: Int,
    @SerializedName("user_email")
    val userEmail: String? = null,
    val name: String? = null,
    val description: String? = null,
    val status: String? = null,
//    val images: Array<String>? = null
)
