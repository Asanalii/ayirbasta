package com.example.ayirbasta.pages.trades.api

import com.google.gson.annotations.SerializedName

data class CreateTradeParam(
    @SerializedName("giver_id")
    val giver: Int,
    @SerializedName("receiver_id")
    val receiver: Int
)
