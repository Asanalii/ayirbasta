package com.example.ayirbasta.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.ayirbasta.pages.item.ItemDTO
import com.example.ayirbasta.pages.trades.TradesDTO

abstract class BaseViewHolder<VB: ViewBinding, T>(protected open val binding: VB):
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bindView(item: T)
}

abstract class BaseItemViewHolder<VB: ViewBinding>(override val binding: VB):
        BaseViewHolder<VB,ItemDTO>(binding)

abstract class BaseTradesViewHolder<VB: ViewBinding>(override val binding: VB):
    BaseViewHolder<VB,TradesDTO>(binding)