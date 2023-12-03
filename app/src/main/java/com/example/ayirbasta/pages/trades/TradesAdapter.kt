package com.example.ayirbasta.pages.trades

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator
import androidx.recyclerview.widget.RecyclerView
import com.example.ayirbasta.base.BaseTradesViewHolder
import com.example.ayirbasta.base.BaseViewHolder
import com.example.ayirbasta.databinding.ItemItemBinding
import com.example.ayirbasta.databinding.ItemTradeBinding
import com.example.ayirbasta.pages.item.ItemDTO

class TradesAdapter(
    private val trades: List<TradesDTO>
) : RecyclerView.Adapter<BaseTradesViewHolder<*>>() {
    var itemClick: ((TradesDTO, FragmentNavigator.Extras) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseTradesViewHolder<*> {
        return TradesListViewHolder(
            ItemTradeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), itemClick
        )
    }

    override fun getItemCount(): Int = trades.size

    override fun onBindViewHolder(holder: BaseTradesViewHolder<*>, position: Int) {
        holder.bindView(trades[position])
    }

    class TradesListViewHolder(
        override val binding: ItemTradeBinding,
        private val itemClick: ((TradesDTO, FragmentNavigator.Extras) -> Unit)?,
    ) : BaseTradesViewHolder<ItemTradeBinding>(binding) {

        override fun bindView(trades: TradesDTO) {

//            binding.image.setImageResource(item.images.get(0))
            binding.title.text = trades.name

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

data class TradesDTO(
    val id: Int,
    val userEmail: String,
    val name: String? = null,
    val description: String? = null,
    val status: String? = null,
//    val images: List<String>? = null,
)