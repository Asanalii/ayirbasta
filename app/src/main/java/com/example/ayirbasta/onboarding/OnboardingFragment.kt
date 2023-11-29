package com.example.ayirbasta.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ayirbasta.databinding.FragmentOnboardingBinding

class OnboardingFragment(private val pagesType: OnboardingPagesType?): Fragment() {
    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pagesType?.let {
            binding.pic.setImageResource(it.image)
            binding.descriptionText.text = it.description
            binding.mainText.text = it.mainText
        }
    }
}