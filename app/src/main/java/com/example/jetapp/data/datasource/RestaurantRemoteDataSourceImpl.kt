package com.example.jetapp.data.datasource

import com.example.jetapp.data.api.JetApi
import com.example.jetapp.data.mapper.RestaurantMapper
import com.example.jetapp.domain.model.Restaurant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantRemoteDataSourceImpl(
    private val restaurantMapper: RestaurantMapper = RestaurantMapper(),
) : RestaurantRemoteDataSource {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://uk.api.just-eat.io/restaurants/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val jetApi = retrofit.create(JetApi::class.java)

    override suspend fun getRestaurantsByPostCode(postCode: String): List<Restaurant> {
        val response = jetApi.getRestaurantsByPostCode(postCode)
        return response.restaurants.map { restaurantMapper.map(it) }
    }
}