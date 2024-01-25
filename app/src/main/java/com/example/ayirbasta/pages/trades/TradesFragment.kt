package com.example.ayirbasta.pages.trades

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayirbasta.databinding.FragmentTradesBinding
import com.example.ayirbasta.decorations.OffsetDecoration
import com.example.ayirbasta.pages.trades.api.AvailableTradesResponse
import com.example.ayirbasta.pages.trades.api.TradeInfo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TradesFragment : Fragment() {
    private val binding by lazy { FragmentTradesBinding.inflate(layoutInflater) }
    private val viewModel: TradesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<AvailableTradesResponse>()
        var tradeInfos = emptyList<TradeInfo>()
        var adapter = TradesAdapter()

        binding.tradesList.adapter = adapter
        binding.tradesList.layoutManager =
            LinearLayoutManager(requireContext())

        viewModel.getItem()
        viewModel.getTradesLiveData.observe(viewLifecycleOwner) {
            list.add(it)
            tradeInfos = list.flatMap { it.trade ?: emptyList() }

            if (tradeInfos.isEmpty()) {
                binding.tradesList.isVisible = false
                binding.listEmpty.isVisible = true
            }

            adapter.submitList(tradeInfos)
        }

        binding.tradesList.addItemDecoration(OffsetDecoration(0, 20, 0, 0))


    }
}