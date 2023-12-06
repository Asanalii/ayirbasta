package com.example.ayirbasta.pages.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.ListAdapter
import com.example.ayirbasta.base.BaseItemViewHolder
import com.example.ayirbasta.data.network.ItemInfo
import com.example.ayirbasta.databinding.ItemItemBinding
import com.example.ayirbasta.extensions.base64toPic
import com.example.ayirbasta.pages.item.ItemDiffUtils

class HomeItemsAdapter : ListAdapter<ItemInfo, BaseItemViewHolder<*>>(ItemDiffUtils) {
    var itemClick: ((ItemInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseItemViewHolder<*> {
        return ItemListViewHolder(
            ItemItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), itemClick
        )
    }

    override fun onBindViewHolder(holder: BaseItemViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }

    class ItemListViewHolder(
        override val binding: ItemItemBinding,
        private val itemClick: ((ItemInfo) -> Unit)?,
    ) : BaseItemViewHolder<ItemItemBinding>(binding) {

        override fun bindView(item: ItemInfo) {
            binding.title.text = item.description

            val decodedImage = base64toPic(item.images.toString())
            binding.image.setImageBitmap(decodedImage)


            binding.button.setOnClickListener {
                itemClick?.invoke(item)
            }

        }

    }
}