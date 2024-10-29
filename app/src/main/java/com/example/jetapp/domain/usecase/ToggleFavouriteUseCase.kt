package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.repository.RestaurantRepository
import javax.inject.Inject

class ToggleFavouriteUseCase @Inject constructor(
    private val repository: RestaurantRepository,
) {
    operator fun invoke(restaurantId: Int) = repository.toggleRestaurantIsFavourite(restaurantId)
}