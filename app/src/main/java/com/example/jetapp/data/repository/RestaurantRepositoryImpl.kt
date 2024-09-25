package com.example.jetapp.data.repository

import com.example.jetapp.data.datasource.MockData
import com.example.jetapp.domain.repository.RestaurantRepository

class RestaurantRepositoryImpl : RestaurantRepository {
    private val data = MockData().loadMockData().toMutableList()

    override fun getRestaurantsByPostCode(postCode: String) =
        data.filter { it.postCode.contains(postCode.uppercase()) }

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
    override fun getFavouriteRestaurants() = data.filter { it.isFavourite }
    }
