package com.example.jetapp.ui.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetapp.data.repository.RestaurantRepositoryImpl
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository
import com.example.jetapp.domain.usecase.FilterFavouriteRestaurantsUseCase
import com.example.jetapp.domain.usecase.GetRemoteRestaurantsByPostCodeUseCase
import com.example.jetapp.domain.usecase.GetSortedRestaurantsUseCase
import com.example.jetapp.domain.usecase.ToggleFavouriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel(
    repository: RestaurantRepository = RestaurantRepositoryImpl(),
    private val getSortedRestaurants: GetSortedRestaurantsUseCase = GetSortedRestaurantsUseCase(
        repository
    ),
    private val toggleFavouriteUseCase: ToggleFavouriteUseCase = ToggleFavouriteUseCase(repository),
    private val filterFavouriteRestaurants: FilterFavouriteRestaurantsUseCase = FilterFavouriteRestaurantsUseCase(
        repository
    ),
    private val searchRestaurantsByPostCode: GetRemoteRestaurantsByPostCodeUseCase = GetRemoteRestaurantsByPostCodeUseCase(
        repository
    ),
) : ViewModel() {

    private val _restaurantsState = mutableStateOf<List<Restaurant>>(emptyList())
    val restaurantsState: State<List<Restaurant>> = _restaurantsState
    private var lastSearchedPostCode = ""

    init {
        getRestaurantsByPostCode("ec4m")
    }
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

    fun getRestaurantsByPostCode(postCode: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d("apitest", searchRestaurantsByPostCode(postCode).toString())
            } catch (e: HttpException) {
                Log.e("apitest", e.message ?: "ERROR")
            }
        }
    }
}