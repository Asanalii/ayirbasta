package com.example.ayirbasta.pages.trades

import androidx.lifecycle.MutableLiveData
import com.example.ayirbasta.base.BaseViewModel
import com.example.ayirbasta.pages.trades.api.AvailableTradesResponse
import com.example.ayirbasta.pages.trades.api.CreateTradeResponse
import com.example.ayirbasta.pages.trades.api.CreateTradeUseCase
import com.example.ayirbasta.pages.trades.api.GetAvailableTradesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TradesViewModel @Inject constructor(
    private val getItems: GetAvailableTradesUseCase,
    private val createItem: CreateTradeUseCase,

) : BaseViewModel() {

    private val _getTradesLiveData = MutableLiveData<AvailableTradesResponse>()
    val getTradesLiveData = _getTradesLiveData

    private val _createTradeLiveData = MutableLiveData<CreateTradeResponse>()
    val createTradeLiveData = _createTradeLiveData

    fun getItem() {
        launch(
            request = {
                getItems.execute()
            },
            onSuccess = {
                _getTradesLiveData.postValue(it)
            }
        )
    }

    fun createTrade(giver: Int, receiver: Int){
        launch(
            request = {
                createItem.execute(giver, receiver)
            },
            onSuccess = {
                _createTradeLiveData.postValue(it)
            }
        )
    }

}