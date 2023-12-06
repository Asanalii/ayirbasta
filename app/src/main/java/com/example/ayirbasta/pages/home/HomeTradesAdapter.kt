package com.example.ayirbasta.pages.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.ayirbasta.base.BaseAvailableTradesViewHolder
import com.example.ayirbasta.base.BaseItemViewHolder
import com.example.ayirbasta.databinding.ItemHomeItemBinding
import com.example.ayirbasta.databinding.ItemItemBinding
import com.example.ayirbasta.extensions.base64toPic
import com.example.ayirbasta.pages.trades.api.TradeInfo

class HomeTradesAdapter : ListAdapter<TradeInfo, BaseAvailableTradesViewHolder<*>>(ItemDiffUtils) {
    var itemClick: ((TradeInfo, FragmentNavigator.Extras) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseAvailableTradesViewHolder<*> {
        return ItemListViewHolder(
            ItemHomeItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), itemClick
        )
    }

    override fun onBindViewHolder(holder: BaseAvailableTradesViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }

    class ItemListViewHolder(
        override val binding: ItemHomeItemBinding,
        private val itemClick: ((TradeInfo, FragmentNavigator.Extras) -> Unit)?,
    ) : BaseAvailableTradesViewHolder<ItemHomeItemBinding>(binding) {

        override fun bindView(item: TradeInfo) {
            val imageBitmap = base64toPic(item.giver?.images.toString())
            binding.image.setImageBitmap(imageBitmap)
            /*binding.title.text = item.description

            binding.title.transitionName = item.name.toString()

            val decodedImage = base64toPic(item.images.toString())
            binding.image.setImageBitmap(decodedImage)


            val extras = FragmentNavigatorExtras(
                binding.title to "actionTitle",
            )

            binding.button.setOnClickListener {
                itemClick?.invoke(item,extras)
            }*/

        }

    }
}

object ItemDiffUtils : DiffUtil.ItemCallback<TradeInfo>() {
    override fun areItemsTheSame(oldItem: TradeInfo, newItem: TradeInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TradeInfo, newItem: TradeInfo): Boolean {
        return oldItem == newItem
    }
}