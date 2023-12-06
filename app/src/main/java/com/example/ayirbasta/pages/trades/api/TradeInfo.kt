package com.example.ayirbasta.pages.trades.api

import com.example.ayirbasta.data.network.ItemInfo
import com.google.gson.annotations.SerializedName

data class TradeInfo(
    @SerializedName("_id")
    val id: Int? = null,
    val giver: ItemInfo? = null,
    val receiver: ItemInfo? = null,
    val status: String? = null
)
