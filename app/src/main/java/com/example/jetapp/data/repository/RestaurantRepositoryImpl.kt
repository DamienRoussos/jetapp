package com.example.jetapp.data.repository

import android.util.Log
import com.example.jetapp.data.datasource.MockData
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository

class RestaurantRepositoryImpl : RestaurantRepository {
    private val data = MockData().loadMockData().toMutableList()

    override fun getRestaurantsByPostCode(postCode: String): List<Restaurant> {
        return data.filter { it.postCode.contains(postCode.uppercase()) }
    }

    //    adjust for favourite and unfavourite
    override fun toggleRestaurantIsFavourite(restaurantId: Int) {
        val index = data.indexOfFirst { it.id == restaurantId }
        if (index == -1) return
//        val restaurant = data[index]
//        data[index] = restaurant.copy(isFavourite = !restaurant.isFavourite)

        data.indexOfFirst { it.id == restaurantId }
            .takeIf { it != -1 }
            ?.let {
                val restaurant = data[index]
                data[index] = restaurant.copy(isFavourite = !restaurant.isFavourite)
            }
//        data = data.map {restaurant ->
//            if(restaurant.id == restaurantId) {
//                restaurant.copy(isFavourite = !restaurant.isFavourite)
//            } else {
//                restaurant
//            }
//        }
//        Log.d("toggle",data.toString())
    }

    override fun getFavouriteRestaurants(): List<Restaurant> {
        Log.d("get", data.toString())
        return data.filter { it.isFavourite }
    }
}