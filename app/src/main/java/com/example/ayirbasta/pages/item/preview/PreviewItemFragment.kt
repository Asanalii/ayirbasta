package com.example.ayirbasta.pages.item.preview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ayirbasta.adapters.ViewPagerAdapter
import com.example.ayirbasta.databinding.FragmentPreviewItemBinding
import com.google.android.material.tabs.TabLayoutMediator

class PreviewItemFragment:Fragment() {

    private val binding by lazy { FragmentPreviewItemBinding.inflate(layoutInflater) }
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
        ItemPicturesType.values().forEach {
            picsList.add(PreviewItemVpFragment(it))
        }
        val adapter = ViewPagerAdapter(parentFragmentManager, lifecycle, picsList)

        binding.viewPager.adapter = adapter
        binding.viewPager.currentItem = 0

        TabLayoutMediator(binding.bottomTab, binding.viewPager){tab, position ->
            tab.view.isClickable = false

        }.attach()

    }


}