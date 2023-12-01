package com.example.ayirbasta.data

import androidx.lifecycle.MutableLiveData
import com.example.ayirbasta.base.BaseViewModel
import com.example.ayirbasta.data.network.HealthcheckResponse
import com.example.ayirbasta.data.network.SignInResponse
import com.example.ayirbasta.data.use_cases.GetHealthcheckUseCase
import com.example.ayirbasta.data.use_cases.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getHealthcheck: GetHealthcheckUseCase,
    private val signIn: SignInUseCase
): BaseViewModel() {

    private val _getHealthcheckLiveData = MutableLiveData<HealthcheckResponse>()
    val getHealthcheckLiveData = _getHealthcheckLiveData


    private val _signInLiveData = MutableLiveData<SignInResponse>()
    val signInLiveData = _signInLiveData
    fun getHealthcheck(){
        launch(
            request = {
                getHealthcheck.execute()
            },
            onSuccess = {
                _getHealthcheckLiveData.postValue(it)
            }
        )
    }

    fun signIn(email: String, password: String){
        launch(
            request = {
                signIn.execute(email, password)
            },
            onSuccess = {
                _signInLiveData.postValue(it)
            }
        )
    }


}

