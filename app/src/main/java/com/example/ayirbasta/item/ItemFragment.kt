package com.example.ayirbasta.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ayirbasta.databinding.FragmentItemBinding
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



    }
}