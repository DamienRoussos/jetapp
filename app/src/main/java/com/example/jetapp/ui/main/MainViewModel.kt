package com.example.jetapp.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetapp.data.MockData
import com.example.jetapp.data.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {

    private val mockData = MockData().loadMockData()

    private val _restaurantsState = mutableStateOf<List<Restaurant>>(emptyList())
    val restaurantsState: State<List<Restaurant>> = _restaurantsState

//    private val _restaurantsFlow = MutableStateFlow<List<Restaurant>>(emptyList())
//    val restaurantsFlow: StateFlow<List<Restaurant>> = _restaurantsFlow
//
//    private val _restaurantsLiveData = MutableLiveData<List<Restaurant>>()
//    val restaurantsLiveData: LiveData<List<Restaurant>> = _restaurantsLiveData

    fun searchRestaurantByPostCode(postCode: String) {
        _restaurantsState.value = mockData.filter { it.postCode.contains(postCode.uppercase()) }
//        _restaurantsFlow.value += MockData().loadMockData()
//        _restaurantsLiveData.value = _restaurantsLiveData.value

    }
}