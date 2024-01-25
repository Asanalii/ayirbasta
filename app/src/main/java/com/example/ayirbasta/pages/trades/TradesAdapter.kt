package com.example.ayirbasta.pages.trades

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ayirbasta.base.BaseTradesViewHolder
import com.example.ayirbasta.base.BaseViewHolder
import com.example.ayirbasta.data.network.ItemInfo
import com.example.ayirbasta.databinding.ItemItemBinding
import com.example.ayirbasta.databinding.ItemTradeBinding
import com.example.ayirbasta.pages.trades.api.TradeInfo

class TradesAdapter: ListAdapter<TradeInfo,BaseTradesViewHolder<*>>(TradeDiffUtils) {
    var itemClick: ((TradeInfo, FragmentNavigator.Extras) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseTradesViewHolder<*> {
        return TradesListViewHolder(
            ItemTradeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), itemClick
        )
    }


    override fun onBindViewHolder(holder: BaseTradesViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }

    class TradesListViewHolder(
        override val binding: ItemTradeBinding,
        private val itemClick: ((TradeInfo, FragmentNavigator.Extras) -> Unit)?,
    ) : BaseTradesViewHolder<ItemTradeBinding>(binding) {

        override fun bindView(trades: TradeInfo) {

//            binding.title.text = trades.name


        }

    }
}

object TradeDiffUtils : DiffUtil.ItemCallback<TradeInfo>() {
    override fun areItemsTheSame(oldItem: TradeInfo, newItem: TradeInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TradeInfo, newItem: TradeInfo): Boolean {
        return oldItem == newItem
    }
}


