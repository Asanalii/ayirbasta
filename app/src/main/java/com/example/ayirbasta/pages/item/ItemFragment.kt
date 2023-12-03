package com.example.ayirbasta.pages.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ayirbasta.R
import com.example.ayirbasta.databinding.FragmentAddItemBinding
import com.example.ayirbasta.databinding.FragmentItemBinding
import com.example.ayirbasta.decorations.OffsetDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemFragment: Fragment() {
    private val binding by lazy { FragmentItemBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ItemAdapter(ItemList.list)

        binding.itemList.adapter = adapter
        binding.itemList.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)

//        if(!binding.listEmpty.isGone) binding.root.strokeColor = resources.getColor(R.color.black)

        binding.itemList.addItemDecoration(OffsetDecoration(3,1,0,10))

        /*adapter.itemClick = { item, extras ->
            findNavController().navigate(

            )
        }*/

    }
}