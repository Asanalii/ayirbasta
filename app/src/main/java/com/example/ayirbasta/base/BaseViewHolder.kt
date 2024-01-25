package com.example.ayirbasta.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.ayirbasta.data.network.ItemInfo

import com.example.ayirbasta.pages.trades.api.TradeInfo

abstract class BaseViewHolder<VB : ViewBinding, T>(protected open val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bindView(item: T)
}

abstract class BaseItemViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, ItemInfo>(binding)

abstract class BaseTradesViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, TradeInfo>(binding)

abstract class BaseAvailableTradesViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, TradeInfo>(binding)
