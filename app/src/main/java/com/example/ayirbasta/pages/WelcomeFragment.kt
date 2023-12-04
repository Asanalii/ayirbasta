package com.example.ayirbasta.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ayirbasta.databinding.FragmentWelcomeBinding

class WelcomeFragment: Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            findNavController().navigate(
                WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()
            )
        }

        binding.signUp.setOnClickListener {
            findNavController().navigate(
                WelcomeFragmentDirections.actionWelcomeFragmentToRegisterFragment()
            )
        }

    }

}