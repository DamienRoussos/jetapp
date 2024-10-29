package com.example.jetapp.data.datasource

import com.example.jetapp.data.api.JetApi
import com.example.jetapp.data.mapper.RestaurantMapper
import com.example.jetapp.domain.model.Restaurant
import javax.inject.Inject

class RestaurantRemoteDataSourceImpl @Inject constructor(
    private val restaurantMapper: RestaurantMapper,
    private val jetApi: JetApi
) : RestaurantRemoteDataSource {

    override suspend fun getRestaurantsByPostCode(postCode: String): List<Restaurant> {
        val response = jetApi.getRestaurantsByPostCode(postCode)
        return response.restaurants.map { restaurantMapper.map(it) }
    }
}