package com.example.ayirbasta.pages.item

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ayirbasta.data.network.ItemInfo
import com.example.ayirbasta.databinding.FragmentItemBinding
import com.example.ayirbasta.decorations.OffsetDecoration
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemFragment : Fragment() {
    private val binding by lazy { FragmentItemBinding.inflate(layoutInflater) }
    private val viewModel: ItemListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<ItemsOfUserResponse>()
        var itemInfos = emptyList<ItemInfo>()
        var adapter = ItemAdapter()

        binding.itemList.adapter = adapter
        binding.itemList.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.itemList.addItemDecoration(OffsetDecoration(3, 1, 0, 10))


        viewModel.getItem()
        viewModel.getItemsLiveData.observe(viewLifecycleOwner) {
            list.add(it)
            itemInfos = list.flatMap { it.items ?: emptyList() }

            if (itemInfos.isEmpty()) {
                binding.itemList.isVisible = false
                binding.addItemForAll.isVisible = false
                binding.listEmpty.isVisible = true
            }

            adapter.submitList(itemInfos)

        }

        binding.addItem.setOnClickListener {
            findNavController().navigate(
                ItemFragmentDirections.actionItemFragmentToItemAddFragment()
            )
        }

        binding.addItemForAll.setOnClickListener {
            findNavController().navigate(
                ItemFragmentDirections.actionItemFragmentToItemAddFragment()
            )
        }

        adapter.itemClick = { item, extras ->
            findNavController().navigate(
                ItemFragmentDirections.actionItemFragmentToPreviewItemFragment(item.id), extras
            )
        }

    }
}