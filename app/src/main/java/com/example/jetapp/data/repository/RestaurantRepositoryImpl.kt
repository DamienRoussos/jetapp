package com.example.jetapp.data.repository

import com.example.jetapp.data.datasource.MockData
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository

class RestaurantRepositoryImpl : RestaurantRepository {
    private val data = MockData().loadMockData()
    private val favourites: List<Restaurant> = emptyList()

    override fun getRestaurantsByPostCode(postCode: String): List<Restaurant> {
        return data.filter { it.postCode.contains(postCode.uppercase()) }
    }

    override fun setFavouriteRestaurant(restaurantId: Int) {
        data.find {
            it.id == restaurantId
        }
    }

    override fun getFavouriteRestaurants(): List<Restaurant> {
        return data.filter { it.isFavourite }
    }
}