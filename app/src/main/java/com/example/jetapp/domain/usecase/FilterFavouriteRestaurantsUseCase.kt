package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository
import javax.inject.Inject

class FilterFavouriteRestaurantsUseCase @Inject constructor(
    private val repository: RestaurantRepository,
) {
    operator fun invoke(): List<Restaurant> =
        repository.filterFavouriteRestaurants().sortedBy { it.name }
}