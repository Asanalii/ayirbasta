package com.example.ayirbasta.pages.item.api

import com.example.ayirbasta.data.network.ItemInfo

data class AllItemsResponse(
    val items: List<ItemInfo>? = null
)
