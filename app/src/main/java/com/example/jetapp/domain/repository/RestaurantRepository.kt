package com.example.jetapp.domain.repository

import com.example.jetapp.domain.model.Restaurant

interface RestaurantRepository {
    fun getRestaurantsByPostCode(postCode: String): List<Restaurant>
    fun setFavouriteRestaurant(restaurantId: Int)
    fun getFavouriteRestaurants(): List<Restaurant>
}