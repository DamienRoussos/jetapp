package com.example.jetapp.data.datasource

import com.example.jetapp.domain.model.Restaurant

interface RestaurantRemoteDataSource {
    suspend fun getRestaurantsByPostCode(postCode: String): List<Restaurant>
}