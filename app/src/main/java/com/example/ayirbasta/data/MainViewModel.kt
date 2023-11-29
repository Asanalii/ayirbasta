package com.example.ayirbasta.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ayirbasta.data.network.HealthcheckResponse
import com.example.ayirbasta.data.network.SignInResponse
import com.example.ayirbasta.data.use_cases.GetHealthcheckUseCase
import com.example.ayirbasta.data.use_cases.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
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

abstract class BaseViewModel: ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO + Job())

    private var _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    private var _exceptionLiveData = MutableLiveData<String?>()
    val exceptionLiveData: LiveData<String?> = _exceptionLiveData

    fun <T> launch(
        request: suspend () -> T,
        onSuccess: (T) -> Unit = { }
    ) {
        coroutineScope.launch {
            try {
                _loadingLiveData.postValue(true)
                val response = request.invoke()
                onSuccess.invoke(response)
            } catch (e: Exception) {
                _exceptionLiveData.postValue(e.message)
                Log.e(">>>", e.message.orEmpty())
            } finally {
                _loadingLiveData.postValue(false)
            }
        }
    }
}