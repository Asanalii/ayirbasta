package com.example.ayirbasta.pages.item

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ayirbasta.base.BaseViewModel
import com.example.ayirbasta.pages.item.api.GetItemOfUserUseCase
import com.example.ayirbasta.pages.item.api.ItemsOfUserResponse
import javax.inject.Inject

/*
class ItemEditViewModel @Inject constructor(
    private val updateItem: UpdateItemByIdUseCase
) : BaseViewModel() {

    private val _updateItemByIdLiveData = MutableLiveData<ItemsOfUserResponse>()
    val updateItemByIdLiveData = _updateItemByIdLiveData

    fun getItem() {
        launch(
            request = {
                updateItem.execute()
            },
            onSuccess = {
                _updateItemByIdLiveData.postValue(it)
            }
        )
    }

}*/
