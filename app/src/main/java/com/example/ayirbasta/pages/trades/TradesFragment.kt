package com.example.ayirbasta.pages.trades

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayirbasta.databinding.FragmentTradesBinding
import com.example.ayirbasta.decorations.OffsetDecoration
import com.example.ayirbasta.pages.item.ItemAdapter
import com.example.ayirbasta.pages.item.ItemList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TradesFragment:Fragment() {
    private val binding by lazy { FragmentTradesBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TradesAdapter(TradesList.list)

        binding.tradesList.adapter = adapter
        binding.tradesList.layoutManager =
            LinearLayoutManager(requireContext())

        binding.tradesList.addItemDecoration(OffsetDecoration(0,20,0,0))


    }
}