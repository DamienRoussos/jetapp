package com.example.jetapp.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.usecase.GetFavouriteRestaurantsUseCase
import com.example.jetapp.domain.usecase.GetSortedRestaurantsUseCase
import com.example.jetapp.domain.usecase.SetFavouriteRestaurantUseCase

class MainViewModel(
    private val getSortedRestaurants: GetSortedRestaurantsUseCase = GetSortedRestaurantsUseCase(),
    private val setFavouriteRestaurant: SetFavouriteRestaurantUseCase = SetFavouriteRestaurantUseCase(),
    private val getFavouriteRestaurant: GetFavouriteRestaurantsUseCase = GetFavouriteRestaurantsUseCase()
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

    fun setRestaurantAsFavourite(restaurantId: Int) {

//        _restaurantsState.value = _restaurantsState.value.map { restaurant ->
//            if (restaurant.id == restaurantId) {
                setFavouriteRestaurant(restaurantId)
//                restaurant.copy(isFavourite = true)
//            } else {
//                restaurant
//            }
//        }
    }

    fun getFavouriteRestaurants(isFavourite: Boolean) {
        _restaurantsState.value = getFavouriteRestaurant(isFavourite)
    }
}