package com.example.jetapp.domain.usecase

import com.example.jetapp.data.repository.RestaurantRepositoryImpl
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository

class GetSortedRestaurantsUseCase(
    private val repository: RestaurantRepository = RestaurantRepositoryImpl(),
) {
    operator fun invoke(postCode: String): List<Restaurant> {
        return repository.getRestaurantsByPostCode(postCode).sortedBy { it.name }
    }
}