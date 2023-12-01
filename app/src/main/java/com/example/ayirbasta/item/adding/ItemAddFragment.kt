package com.example.ayirbasta.item.adding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ayirbasta.databinding.FragmentAddItemBinding

//@AndroidEntryPoint
class ItemAddFragment:Fragment() {
    private val binding by lazy { FragmentAddItemBinding.inflate(layoutInflater) }
    private val viewModel: ItemAddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addItem.setOnClickListener {
            viewModel.createItem(binding.inputViewItemName.text.toString(), binding.inputViewItemAbout.text.toString())
            
        }

    }

}