package com.example.ayirbasta.pages.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ayirbasta.data.MainViewModel
import com.example.ayirbasta.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: Fragment() {
    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.loginButton.setOnClickListener {
            viewModel.signIn(binding.emailInput.text.toString(), binding.passwordInput.text.toString())

            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToItemFragment()
            )
        }


    }
}