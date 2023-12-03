package com.example.ayirbasta.pages.item.adding

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.example.ayirbasta.databinding.FragmentAddItemBinding
import com.example.ayirbasta.extensions.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemAddFragment:Fragment() {
    private val binding by lazy { FragmentAddItemBinding.inflate(layoutInflater) }
    private val viewModel: ItemAddViewModel by viewModels()

    private val selectedPicturesLiveData = MutableLiveData<List<Uri>>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(selectedPicturesLiveData){
            it?.firstOrNull()?.let { uri ->
                binding.pic1.isVisible = false
                binding.selectedPic1.isVisible = true
                Glide.with(requireContext()).load(uri).into(binding.selectedPic1)
            }

            if(it.count() >= 2) {
                binding.pic2.isVisible = false
                binding.selectedPic2.isVisible = true
                Glide.with(requireContext()).load(it[1]).into(binding.selectedPic2)
            }

            if(it.count() >= 3) {
                TODO("Доделать")
                /*binding.pic2.isVisible = false
                binding.selectedPic2.isVisible = true
                Glide.with(requireContext()).load(it[1]).into(binding.selectedPic2)*/
            }

        }


        binding.addItem.setOnClickListener {
            TODO("Uri картинки -> bitmap -> biteArray ")


//            viewModel.createItem(binding.inputViewItemName.text.toString(), binding.inputViewItemAbout.text.toString(),)

            TODO("Нужно когда success -> в item page переход")
        }

    }
}


