package com.example.ayirbasta.pages.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayirbasta.data.network.ItemInfo
import com.example.ayirbasta.databinding.FragmentHomeBinding
import com.example.ayirbasta.pages.home.api.AvailableTradesResponse
import com.example.ayirbasta.pages.item.api.AllItemsResponse
import com.example.ayirbasta.pages.trades.api.TradeInfo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listTrades = mutableListOf<AvailableTradesResponse>()
        var itemTradesInfos = emptyList<TradeInfo>()

        val listItems = mutableListOf<AllItemsResponse>()
        var itemInfos = emptyList<ItemInfo>()

        var adapterTrades = HomeTradesAdapter()
        var adapterItems = HomeItemsAdapter()

        binding.listAvailableTrades.adapter = adapterTrades
        binding.listAvailableTrades.layoutManager = LinearLayoutManager(requireContext())
//            GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
//        binding.listAvailableItems.addItemDecoration(OffsetDecoration(3, 1, 0, 10))

        binding.listAvailableItems.adapter = adapterItems
        binding.listAvailableItems.layoutManager =
            GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)

        viewModel.getTrades()
        viewModel.getNewTradesLiveData.observe(viewLifecycleOwner) { trades ->
            listTrades.add(trades)

            itemTradesInfos = listTrades.flatMap { it.trade ?: emptyList() }
                .filter { tradeInfo -> tradeInfo.status == "waiting_action" }

            adapterTrades.submitList(itemTradesInfos)
        }

        viewModel.getItems()
        viewModel.getAllItemsLiveData.observe(viewLifecycleOwner) { item ->
            listItems.add(item)

            itemInfos = listItems.flatMap { item.items ?: emptyList() }

            adapterItems.submitList(itemInfos)
        }

        adapterItems.itemClick = { item ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToActionItemFragment(item.id)
            )

        }


    }
}