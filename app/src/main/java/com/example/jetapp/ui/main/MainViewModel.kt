package com.example.jetapp.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.usecase.GetSortedRestaurantsUseCase

class MainViewModel(
    private val getSortedRestaurants: GetSortedRestaurantsUseCase = GetSortedRestaurantsUseCase(),
) : ViewModel() {

    private val _restaurantsState = mutableStateOf<List<Restaurant>>(emptyList())
    val restaurantsState: State<List<Restaurant>> = _restaurantsState

//    private val _restaurantsFlow = MutableStateFlow<List<Restaurant>>(emptyList())
//    val restaurantsFlow: StateFlow<List<Restaurant>> = _restaurantsFlow
//
//    private val _restaurantsLiveData = MutableLiveData<List<Restaurant>>()
//    val restaurantsLiveData: LiveData<List<Restaurant>> = _restaurantsLiveData

    fun searchRestaurantByPostCode(postCode: String) {
        _restaurantsState.value = getSortedRestaurants(postCode)


//        _restaurantsFlow.value += MockData().loadMockData()
//        _restaurantsLiveData.value = _restaurantsLiveData.value

    }
}