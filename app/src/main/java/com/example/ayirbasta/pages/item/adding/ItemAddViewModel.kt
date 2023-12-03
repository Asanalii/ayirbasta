package com.example.ayirbasta.pages.item.adding

import androidx.lifecycle.MutableLiveData
import com.example.ayirbasta.base.BaseViewModel
import com.example.ayirbasta.data.network.CreateItemResponse
import com.example.ayirbasta.data.network.SignInResponse
import com.example.ayirbasta.data.use_cases.CreateItemUseCase
import com.example.ayirbasta.data.use_cases.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemAddViewModel @Inject constructor(
    private val createItem: CreateItemUseCase
): BaseViewModel() {

    private val _createItemLiveData = MutableLiveData<CreateItemResponse>()
    val createItemLiveData = _createItemLiveData

    fun createItem(name: String, description: String, images: ByteArray){
        launch(
            request = {
                createItem.execute(name, description, images)
            },
            onSuccess = {
                _createItemLiveData.postValue(it)
            }
        )
    }
}