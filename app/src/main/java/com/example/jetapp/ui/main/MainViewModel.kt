package com.example.jetapp.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetapp.data.MockData
import com.example.jetapp.data.RestaurantModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {

    private val _restaurantsState = mutableStateOf<List<RestaurantModel>>(emptyList())
    val restaurantsState: State<List<RestaurantModel>> = _restaurantsState

    private val _restaurantsFlow = MutableStateFlow<List<RestaurantModel>>(emptyList())
    val restaurantsFlow: StateFlow<List<RestaurantModel>> = _restaurantsFlow

    private val _restaurantsLiveData = MutableLiveData<List<RestaurantModel>>()
    val restaurantsLiveData: LiveData<List<RestaurantModel>> = _restaurantsLiveData

    fun searchRestaurant(postCode: String) {
        _restaurantsState.value += MockData().loadMockData()
        _restaurantsFlow.value += MockData().loadMockData()
//        _restaurantsLiveData.value = _restaurantsLiveData.value

    }
}