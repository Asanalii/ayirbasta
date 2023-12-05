package com.example.ayirbasta.pages.item.adding

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.example.ayirbasta.databinding.FragmentAddItemBinding
import com.example.ayirbasta.extensions.getBitmap
import com.example.ayirbasta.extensions.observe
import com.example.ayirbasta.extensions.toByteArray
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemAddFragment : Fragment() {
    private val binding by lazy { FragmentAddItemBinding.inflate(layoutInflater) }
    private val viewModel: ItemAddViewModel by viewModels()

    private val selectedPicturesLiveData = MutableLiveData<List<Uri>>()

    var pic1_uri: Uri? = null
    var pic2_uri: Uri? = null
    var pic3_uri: Uri? = null

    val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->

            if (uri != null) {
                Log.d("PhotoPicker", "Selected URI: $uri")
                pic1_uri = uri
                updateImageView(uri, binding.selectedPic1, binding.pic1)

            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.pic1.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }


        observe(selectedPicturesLiveData) {
            it?.firstOrNull()?.let { uri ->
                binding.pic1.isVisible = false
                binding.selectedPic1.isVisible = true
                Glide.with(requireContext()).load(uri).into(binding.selectedPic1)
            }

            if (it.count() >= 2) {
                binding.pic2.isVisible = false
                binding.selectedPic2.isVisible = true
                Glide.with(requireContext()).load(it[1]).into(binding.selectedPic2)
            }

            if (it.count() >= 3) {
                TODO("Доделать")
                /*binding.pic2.isVisible = false
                binding.selectedPic2.isVisible = true
                Glide.with(requireContext()).load(it[1]).into(binding.selectedPic2)*/
            }

        }


        binding.addItem.setOnClickListener {
            val bitmap1 = pic1_uri.getBitmap(requireContext())
            val byteArray1 = bitmap1?.toByteArray()

            if (byteArray1 != null) {
                viewModel.createItem(
                    binding.inputViewItemName.text.toString(),
                    binding.inputViewItemAbout.text.toString(),
                    byteArray1
                )
            }

        }

    }

    private fun updateImageView(uri: Uri?, imageView: ImageView, placeholderView: View) {
        if (uri != null) {
            placeholderView.isVisible = false
            imageView.isVisible = true
            Glide.with(requireContext()).load(uri).into(imageView)
        } else {
            placeholderView.isVisible = true
            imageView.isVisible = false
        }
    }
}


