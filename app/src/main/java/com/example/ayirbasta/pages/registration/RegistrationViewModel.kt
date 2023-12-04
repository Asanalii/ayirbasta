package com.example.ayirbasta.pages.registration

import androidx.lifecycle.MutableLiveData
import com.example.ayirbasta.base.BaseViewModel
import com.example.ayirbasta.data.network.SignUpResponse
import com.example.ayirbasta.pages.registration.api.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val signUp: SignUpUseCase
) : BaseViewModel() {

    private val _signUpLiveData = MutableLiveData<SignUpResponse>()
    val signUpLiveData = _signUpLiveData
    fun signUp(firstname: String, lastname: String, email: String, password: String) {
        launch(
            request = {
                signUp.execute(firstname, lastname, email, password)
            },
            onSuccess = {
                _signUpLiveData.postValue(it)
            }
        )
    }
}