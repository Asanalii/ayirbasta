package com.example.ayirbasta.pages.home

import androidx.lifecycle.MutableLiveData
import com.example.ayirbasta.base.BaseViewModel
import com.example.ayirbasta.pages.trades.api.AvailableTradesResponse
import com.example.ayirbasta.pages.trades.api.GetAvailableTradesUseCase
import com.example.ayirbasta.pages.item.api.AllItemsResponse
import com.example.ayirbasta.pages.item.api.GetAllItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewTrades: GetAvailableTradesUseCase,
    private val getAvailableItems: GetAllItemsUseCase
) : BaseViewModel() {

    private val _getNewTradesLiveData = MutableLiveData<AvailableTradesResponse>()
    val getNewTradesLiveData = _getNewTradesLiveData

    private val _getAllItemsLiveData = MutableLiveData<AllItemsResponse>()
    val getAllItemsLiveData = _getAllItemsLiveData
    fun getTrades() {
        launch(
            request = {
                getNewTrades.execute()
            },
            onSuccess = {
                _getNewTradesLiveData.postValue(it)
            }
        )
    }

    fun getItems(){
        launch(
            request = {
                getAvailableItems.execute()
            },
            onSuccess = {
                _getAllItemsLiveData.postValue(it)
            }
        )
    }

}