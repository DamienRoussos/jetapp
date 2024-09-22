package com.example.jetapp.data.repository

import android.util.Log
import com.example.jetapp.data.datasource.MockData
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository

class RestaurantRepositoryImpl : RestaurantRepository {
    private var data = MockData().loadMockData()

    override fun getRestaurantsByPostCode(postCode: String): List<Restaurant> {
        return data.filter { it.postCode.contains(postCode.uppercase()) }
    }

    //    adjust for favourite and unfavourite
    override fun toggleRestaurantIsFavourite(restaurantId: Int) {
        data = data.map {restaurant ->
            if(restaurant.id == restaurantId) {
                restaurant.copy(isFavourite = !restaurant.isFavourite)
            } else {
                restaurant
            }
        }
        Log.d("toggle",data.toString())
    }

    override fun getFavouriteRestaurants(isFavourite: Boolean): List<Restaurant> {
        Log.d("get",data.toString())
        return data.filter { it.isFavourite == isFavourite }
    }
}