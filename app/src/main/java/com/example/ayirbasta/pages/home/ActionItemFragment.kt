package com.example.ayirbasta.pages.home

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ayirbasta.adapters.ViewPagerAdapter
import com.example.ayirbasta.data.network.ItemInfo
import com.example.ayirbasta.databinding.FragmentItemActionBinding
import com.example.ayirbasta.databinding.FragmentPreviewItemBinding
import com.example.ayirbasta.decorations.OffsetDecoration
import com.example.ayirbasta.extensions.base64toPic
import com.example.ayirbasta.pages.item.ItemAdapter
import com.example.ayirbasta.pages.item.ItemByIdViewModel
import com.example.ayirbasta.pages.item.ItemListViewModel
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse
import com.example.ayirbasta.pages.item.preview.PreviewItemFragmentArgs
import com.example.ayirbasta.pages.item.preview.PreviewItemFragmentDirections
import com.example.ayirbasta.pages.item.preview.PreviewItemVpFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActionItemFragment : Fragment() {

    private val binding by lazy { FragmentItemActionBinding.inflate(layoutInflater) }
    private val args: ActionItemFragmentArgs by navArgs()

    private val viewModelGetItem: ItemByIdViewModel by viewModels()
    private val viewModelAllUserItems: ItemListViewModel by viewModels()




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val picsList: MutableList<Fragment> = mutableListOf()

        val list = mutableListOf<ItemsOfUserResponse>()
        var itemInfos = emptyList<ItemInfo>()
        var adapter = ItemAdapter()

        binding.userItemsList.adapter = adapter
        binding.userItemsList.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.userItemsList.addItemDecoration(OffsetDecoration(3, 1, 0, 10))

        var pics: Bitmap? = null

        viewModelGetItem.getItem(args.id)
        viewModelGetItem.getItemLiveData.observe(viewLifecycleOwner) {
            binding.itemName.text = it.item?.name
            binding.itemDescription.text = it.item?.description

            pics = base64toPic(it.item?.images.toString())
            picsList.add(PreviewItemVpFragment(pics))

        }


        viewModelAllUserItems.getItem()
        viewModelAllUserItems.getItemsLiveData.observe(viewLifecycleOwner) {
            list.add(it)
            itemInfos = list.flatMap { it.items ?: emptyList() }

            if (itemInfos.isEmpty()) {
                binding.userItemsList.isVisible = false
                binding.listEmpty.isVisible = true
            }

            adapter.submitList(itemInfos)
        }

        adapter.tradeClick = { trade ->
            // receiver это args.id

            // giver это trade.id
        }


        binding.startTrade.setOnClickListener {
            binding.userItemsBlock.visibility = View.VISIBLE

            /*findNavController().navigate(
                PreviewItemFragmentDirections.actionPreviewItemFragmentToEditItemFragment(args.id)
            )*/
        }



    }


}