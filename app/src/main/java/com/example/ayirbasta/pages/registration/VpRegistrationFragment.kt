package com.example.ayirbasta.pages.registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ayirbasta.data.MainViewModel
import com.example.ayirbasta.databinding.FragmentVpRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VpRegistrationFragment(
    private val pagesType: RegistrationPagesType?
) : Fragment() {
    private lateinit var binding: FragmentVpRegistrationBinding
    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVpRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var email = ""
        var password = ""
        var firstname = ""
        var lastname = ""

        pagesType?.let {
            binding.mainInfo.text = it.mainText
            binding.secondaryInfo.text = it.secondaryText

            binding.firstText.text = it.firstInput
            binding.firstInputView.hint = "Enter your ${it.firstInput.lowercase()}"

            binding.secondText.text = it.secondaryInput
//            binding.secondaryInput.inputType =
            binding.secondaryInputView.hint = "Enter your ${it.secondaryInput.lowercase()}"

            binding.thirdText.text = it.thirdInput
            binding.thirdInputView.hint = "Enter your ${it.thirdInput.lowercase()}"

            if (binding.thirdText.text == "") {
                binding.thirdInputView.isVisible = false
            }

            binding.createAccountButton.text = it.buttonText
        }

        binding.createAccountButton.setOnClickListener {
            if (binding.createAccountButton.text == "Continue") {
                Toast.makeText(requireContext(), "first page", Toast.LENGTH_SHORT).show()

                if (binding.secondaryInput.text.toString().length < 8) {
                    Toast.makeText(
                        requireContext(),
                        "Password must be at least 8 element",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                email = binding.firstInput.text.toString()
                password = binding.secondaryInput.text.toString()



                if (binding.secondaryInput.text.toString() != binding.thirdInput.text.toString()) {
                    Toast.makeText(requireContext(), "passwords do not match", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            if (binding.createAccountButton.text != "Continue") {
                firstname = binding.firstInput.text.toString()
                lastname = binding.secondaryInput.text.toString()

                Log.e(">>",email)
                Log.e(">><<",password)
                Log.e("<<",firstname)
                Log.e(">>",lastname)


                viewModel.signUp(firstname, lastname, email, password)

                findNavController().navigate(
                    RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                )
            }
        }

    }

}