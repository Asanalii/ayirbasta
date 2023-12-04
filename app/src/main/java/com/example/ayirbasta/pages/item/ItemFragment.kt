package com.example.ayirbasta.pages.item

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ayirbasta.R
import com.example.ayirbasta.data.network.ItemInfo
import com.example.ayirbasta.databinding.FragmentAddItemBinding
import com.example.ayirbasta.databinding.FragmentItemBinding
import com.example.ayirbasta.decorations.OffsetDecoration
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse
import com.example.ayirbasta.pages.registration.RegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class ItemFragment : Fragment() {
    private val binding by lazy { FragmentItemBinding.inflate(layoutInflater) }
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val list = mutableListOf<ItemInfo>()

        viewModel.getItem()
        viewModel.getItemsLiveData.observe(viewLifecycleOwner) {
            it.item?.let { it1 -> list.add(it1) }
        }

        binding.root.setOnClickListener {
            list.forEach {
                Log.e(">>>", it.name.toString())
            }
        }

        val adapter = ItemAdapter(list)

        binding.itemList.adapter = adapter
        binding.itemList.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)

//        if(!binding.listEmpty.isGone) binding.root.strokeColor = resources.getColor(R.color.black)

        binding.itemList.addItemDecoration(OffsetDecoration(3, 1, 0, 10))

        /*adapter.itemClick = { item, extras ->
            findNavController().navigate(

            )
        }*/

    }
}