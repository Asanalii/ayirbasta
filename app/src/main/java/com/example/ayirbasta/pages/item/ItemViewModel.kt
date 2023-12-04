package com.example.ayirbasta.pages.item

import androidx.lifecycle.MutableLiveData
import com.example.ayirbasta.base.BaseViewModel
import com.example.ayirbasta.pages.item.api.GetItemOfUserUseCase
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItems: GetItemOfUserUseCase
) : BaseViewModel() {

    private val _getItemsLiveData = MutableLiveData<ItemsOfUserResponse>()
    val getItemsLiveData = _getItemsLiveData

    fun getItem(){
        launch(
            request = {
                getItems.execute()
            },
            onSuccess = {
                _getItemsLiveData.postValue(it)
            }
        )
    }

}