package com.example.ayirbasta.data

import androidx.lifecycle.MutableLiveData
import com.example.ayirbasta.base.BaseViewModel
import com.example.ayirbasta.data.network.HealthcheckResponse
import com.example.ayirbasta.pages.login.api.SignInResponse
import com.example.ayirbasta.data.use_cases.GetHealthcheckUseCase
import com.example.ayirbasta.pages.login.api.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getHealthcheck: GetHealthcheckUseCase,
    private val signIn: SignInUseCase,

    ) : BaseViewModel() {

    private val _getHealthcheckLiveData = MutableLiveData<HealthcheckResponse>()
    val getHealthcheckLiveData = _getHealthcheckLiveData

    fun getHealthcheck() {
        launch(
            request = {
                getHealthcheck.execute()
            },
            onSuccess = {
                _getHealthcheckLiveData.postValue(it)
            }
        )
    }


}

