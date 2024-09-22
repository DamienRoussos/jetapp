package com.example.jetapp.domain.usecase

import com.example.jetapp.data.repository.RestaurantRepositoryImpl
import com.example.jetapp.domain.repository.RestaurantRepository

class ToggleFavouriteUseCase(
    private val repository: RestaurantRepository = RestaurantRepositoryImpl(),
) {
    operator fun invoke(restaurantId: Int) {
        return repository.toggleRestaurantIsFavourite(restaurantId)
    }
}