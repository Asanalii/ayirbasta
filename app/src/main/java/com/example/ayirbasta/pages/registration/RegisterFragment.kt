package com.example.ayirbasta.pages.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ayirbasta.adapters.ViewPagerAdapter
import com.example.ayirbasta.data.MainViewModel
import com.example.ayirbasta.databinding.FragmentRegistrationBinding
import com.example.ayirbasta.pages.onboarding.OnboardingPagesType
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment():Fragment() {
    private val binding by lazy { FragmentRegistrationBinding.inflate(layoutInflater) }
//    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pagesList: MutableList<Fragment> = mutableListOf()
        RegistrationPagesType.values().forEach {
            pagesList.add(VpRegistrationFragment(it))
        }
        val adapter = ViewPagerAdapter(childFragmentManager,lifecycle,pagesList)

        binding.viewPager.adapter = adapter
        binding.viewPager.currentItem = 0

//        binding.viewPager.isClickable = false

        TabLayoutMediator(binding.topTab, binding.viewPager) { tab, position ->
            tab.view.isClickable = false


        }.attach()

    }

}