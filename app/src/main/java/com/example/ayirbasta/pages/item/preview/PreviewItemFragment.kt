package com.example.ayirbasta.pages.item.preview

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ayirbasta.adapters.ViewPagerAdapter
import com.example.ayirbasta.data.network.ItemInfo
import com.example.ayirbasta.databinding.FragmentPreviewItemBinding
import com.example.ayirbasta.extensions.base64toPic
import com.example.ayirbasta.pages.item.ItemByIdViewModel
import com.example.ayirbasta.pages.item.ItemListViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PreviewItemFragment : Fragment() {

    private val binding by lazy { FragmentPreviewItemBinding.inflate(layoutInflater) }
    private val args: PreviewItemFragmentArgs by navArgs()
    private val viewModel: ItemByIdViewModel by viewModels()

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

        /*ItemPicturesType.values().forEach {
            picsList.add(PreviewItemVpFragment(it))
        }*/

        var pics: Bitmap? = null
        val adapter = ViewPagerAdapter(parentFragmentManager, lifecycle, picsList)


        viewModel.getItem(args.id)
        viewModel.getItemLiveData.observe(viewLifecycleOwner) {
            binding.itemName.text = it.item?.name
            binding.itemDescription.text = it.item?.description

            pics = base64toPic(it.item?.images.toString())
            picsList.add(PreviewItemVpFragment(pics))

            binding.viewPager.adapter = adapter
        }


//        binding.viewPager.currentItem = 0

        /*TabLayoutMediator(binding.bottomTab, binding.viewPager) { tab, position ->
            tab.view.isClickable = false

        }.attach()*/

        binding.edit.setOnClickListener {
            findNavController().navigate(
                PreviewItemFragmentDirections.actionPreviewItemFragmentToEditItemFragment(args.id)
            )
        }


    }



}