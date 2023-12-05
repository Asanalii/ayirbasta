package com.example.ayirbasta.pages.item

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ayirbasta.base.BaseViewModel
import com.example.ayirbasta.pages.item.api.GetItemByIdUseCase
import com.example.ayirbasta.pages.item.api.GetItemOfUserUseCase
import com.example.ayirbasta.pages.item.api.ItemByIdResponse
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemByIdViewModel @Inject constructor(
    private val getItem: GetItemByIdUseCase
) : BaseViewModel() {

    private val _getItemLiveData = MutableLiveData<ItemByIdResponse>()
    val getItemLiveData = _getItemLiveData

    fun getItem(id: Int){
        launch(
            request = {
                getItem.execute(id)
            },
            onSuccess = {
                _getItemLiveData.postValue(it)
            }
        )
    }

}