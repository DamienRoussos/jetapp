package com.example.jetapp.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.usecase.FilterFavouriteRestaurantsUseCase
import com.example.jetapp.domain.usecase.GetRemoteRestaurantsByPostCodeUseCase
import com.example.jetapp.domain.usecase.GetSortedRestaurantsUseCase
import com.example.jetapp.domain.usecase.ToggleFavouriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSortedRestaurants: GetSortedRestaurantsUseCase,
    private val toggleFavouriteUseCase: ToggleFavouriteUseCase,
    private val filterFavouriteRestaurants: FilterFavouriteRestaurantsUseCase,
    private val searchRestaurantsByPostCode: GetRemoteRestaurantsByPostCodeUseCase
) : ViewModel() {

    private val _restaurantsState = mutableStateOf<List<Restaurant>>(emptyList())
    val restaurantsState: State<List<Restaurant>> = _restaurantsState
    private var lastSearchedPostCode = ""

    private val _remoteRestaurantsState = mutableStateOf<List<Restaurant>>(emptyList())
    val remoteRestaurantState: State<List<Restaurant>> = _remoteRestaurantsState


//    init {
//        getRemoteRestaurantsByPostCode("ec4m")
//    }
//    private val _restaurantsFlow = MutableStateFlow<List<Restaurant>>(emptyList())
//    val restaurantsFlow: StateFlow<List<Restaurant>> = _restaurantsFlow
//
//    private val _restaurantsLiveData = MutableLiveData<List<Restaurant>>()
//    val restaurantsLiveData: LiveData<List<Restaurant>> = _restaurantsLiveData

    fun searchRestaurantByPostCode(postCode: String) {
        _restaurantsState.value = getSortedRestaurants(postCode)
        lastSearchedPostCode = postCode

//        _restaurantsFlow.value += MockData().loadMockData()
//        _restaurantsLiveData.value = _restaurantsLiveData.value

    }

    fun toggleRestaurantIsFavourite(restaurantId: Int) {
//        toggleFavouriteUseCase(restaurantId)
        _restaurantsState.value = _restaurantsState.value.map { restaurant ->
            if (restaurant.id == restaurantId) {
                toggleFavouriteUseCase(restaurantId)
                restaurant.copy(isFavourite = !restaurant.isFavourite)
            } else {
                restaurant
            }
        }
    }

    fun filterFavouriteRestaurants(isFavourite: Boolean) {
        if (isFavourite) {
            _restaurantsState.value = filterFavouriteRestaurants()
        } else {
            _restaurantsState.value = getSortedRestaurants(lastSearchedPostCode)
        }
    }


//    removed the explicit dispatcher io with Carlos and let it figured automatically
    fun getRemoteRestaurantsByPostCode(postCode: String) {
        viewModelScope.launch {
            try {
                val restaurants = searchRestaurantsByPostCode(postCode)
                _remoteRestaurantsState.value = restaurants
                println(_remoteRestaurantsState.value)
//                Log.d("apitesttry", restaurants.toString())
            } catch (e: HttpException) {
//                Log.e("apitesterror", e.message ?: "ERROR")
            }
        }
    }
}