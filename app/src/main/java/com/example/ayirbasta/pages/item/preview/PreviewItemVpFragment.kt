package com.example.ayirbasta.pages.item.preview

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ayirbasta.databinding.FragmentVpItemPreviewBinding

class PreviewItemVpFragment(private val pictures: Bitmap?) : Fragment() {
    private lateinit var binding: FragmentVpItemPreviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVpItemPreviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.pic.setImageBitmap(pictures)
    }
}