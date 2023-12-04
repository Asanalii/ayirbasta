package com.example.ayirbasta.pages.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ayirbasta.base.BaseItemViewHolder
import com.example.ayirbasta.base.BaseViewHolder
import com.example.ayirbasta.data.network.ItemInfo
import com.example.ayirbasta.databinding.ItemItemBinding
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse

class ItemAdapter(
    private val items: List<ItemInfo>
): RecyclerView.Adapter<BaseItemViewHolder<*>>() {
    var itemClick: ((ItemDTO, FragmentNavigator.Extras)-> Unit)? = null


    /*object ItemDiffUtils : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem == newItem
        }
    }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseItemViewHolder<*> {
        return ItemListViewHolder(
            ItemItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), itemClick
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseItemViewHolder<*>, position: Int) {
       holder.bindView(items[position])


    }

    class ItemListViewHolder(
        override val binding: ItemItemBinding,
        private val itemClick: ((ItemDTO, FragmentNavigator.Extras) -> Unit)?,
    ) : BaseItemViewHolder<ItemItemBinding>(binding) {

        override fun bindView(item: ItemInfo) {

//            binding.image.setImageResource(item.images.get(0))
            binding.title.text = item.name

            /* binding.image.transitionName = item.id.toString()
            binding.title.transitionName = item.name + item.id.toString()

            val extras = FragmentNavigatorExtras(
                binding.image to "actionImage",
                binding.title to "actionTitle"
            )

            binding.image.setOnClickListener {
                itemClick?.invoke(item,extras)
            } */

        }

    }
}



data class ItemDTO(
    val id: Int,
    val userEmail: String,
    val name: String? = null,
    val description: String? = null,
    val status: String? = null,
//    val images: List<String>? = null,
)