package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.repository.RestaurantRepository

class ToggleFavouriteUseCase(
    private val repository: RestaurantRepository,
) {
    operator fun invoke(restaurantId: Int) = repository.toggleRestaurantIsFavourite(restaurantId)
}