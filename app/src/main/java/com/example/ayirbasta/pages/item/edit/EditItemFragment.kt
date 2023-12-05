package com.example.ayirbasta.pages.item.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ayirbasta.adapters.ViewPagerAdapter
import com.example.ayirbasta.databinding.FragmentEditItemBinding
import com.example.ayirbasta.databinding.FragmentPreviewItemBinding
import com.google.android.material.tabs.TabLayoutMediator

class EditItemFragment : Fragment() {

    private val binding by lazy { FragmentEditItemBinding.inflate(layoutInflater) }
    private val args: EditItemFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.preview.setOnClickListener {
            findNavController().navigate(
                EditItemFragmentDirections.actionEditItemFragmentToPreviewItemFragment(args.id)
            )
        }


    }


}