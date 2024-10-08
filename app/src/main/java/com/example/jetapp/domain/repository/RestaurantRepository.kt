package com.example.jetapp.domain.repository

import com.example.jetapp.domain.model.Restaurant

interface RestaurantRepository {
    fun getRestaurantsByPostCode(postCode: String): List<Restaurant>
    fun toggleRestaurantIsFavourite(restaurantId: Int)
    fun filterFavouriteRestaurants(): List<Restaurant>
    suspend fun searchRemoteRestaurantsByPostCode(postCode: String): List<Restaurant>
}