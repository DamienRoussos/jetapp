package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository

class FilterFavouriteRestaurantsUseCase(
    private val repository: RestaurantRepository,
) {
    operator fun invoke(isFavourite: Boolean): List<Restaurant> {
        return repository.filterRestaurantsByFavourite(isFavourite).sortedBy { it.name }
    }
}