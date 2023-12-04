package com.example.ayirbasta.pages.login

import androidx.lifecycle.MutableLiveData
import com.example.app_study_hilt.data.preferences.Preferences
import com.example.app_study_hilt.data.preferences.SharedPreferencesUtils
import com.example.ayirbasta.base.BaseViewModel
import com.example.ayirbasta.pages.login.api.SignInResponse
import com.example.ayirbasta.pages.login.api.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signIn: SignInUseCase,
    private val preferencesUtils: SharedPreferencesUtils
) : BaseViewModel() {

    private val _signInLiveData = MutableLiveData<SignInResponse>()
    val signInLiveData = _signInLiveData
    fun signIn( email: String, password: String) {

        launch(
            request = {
                signIn.execute(email, password)
            },
            onSuccess = {
                _signInLiveData.postValue(it)
                it?.authenticationToken?.let { it1 ->
                    preferencesUtils.saveToken(Preferences.ACCESS_TOKEN,
                        it1
                    )
                }
            }
        )
    }
}