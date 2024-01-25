package com.example.ayirbasta.pages.item

import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ayirbasta.base.BaseItemViewHolder
import com.example.ayirbasta.base.BaseViewHolder
import com.example.ayirbasta.data.network.ItemInfo
import com.example.ayirbasta.databinding.ItemItemBinding
import com.example.ayirbasta.extensions.base64toPic
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse

class ItemAdapter : ListAdapter<ItemInfo, BaseItemViewHolder<*>>(ItemDiffUtils) {
    var itemClick: ((ItemInfo, FragmentNavigator.Extras) -> Unit)? = null

    var tradeClick: ((ItemInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseItemViewHolder<*> {
        return ItemListViewHolder(
            ItemItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), itemClick, tradeClick
        )
    }

    override fun onBindViewHolder(holder: BaseItemViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }

    class ItemListViewHolder(
        override val binding: ItemItemBinding,
        private val itemClick: ((ItemInfo, FragmentNavigator.Extras) -> Unit)?,
        private val tradeClick: ((ItemInfo) -> Unit)?
    ) : BaseItemViewHolder<ItemItemBinding>(binding) {

        override fun bindView(item: ItemInfo) {
            binding.title.text = item.name

            binding.title.transitionName = item.name.toString()



            val decodedImage = base64toPic(item.images.toString())
            binding.image.setImageBitmap(decodedImage)


            val extras = FragmentNavigatorExtras(
                binding.title to "actionTitle",
            )

            binding.button.setOnClickListener {
                itemClick?.invoke(item,extras)
            }

        }

    }
}

object ItemDiffUtils : DiffUtil.ItemCallback<ItemInfo>() {
    override fun areItemsTheSame(oldItem: ItemInfo, newItem: ItemInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemInfo, newItem: ItemInfo): Boolean {
        return oldItem == newItem
    }
}

