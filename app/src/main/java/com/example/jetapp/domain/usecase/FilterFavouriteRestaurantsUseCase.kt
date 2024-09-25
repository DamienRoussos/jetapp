package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository

class GetFavouriteRestaurantsUseCase(
    private val repository: RestaurantRepository,
) {
    operator fun invoke(): List<Restaurant> {
        return repository.getFavouriteRestaurants().sortedBy { it.name }
    }
}