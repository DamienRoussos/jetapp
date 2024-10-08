package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.repository.RestaurantRepository

class GetSortedRestaurantsUseCase(
    private val repository: RestaurantRepository,
) {
    operator fun invoke(postCode: String) =
        repository.getRestaurantsByPostCode(postCode).sortedBy { it.name }
}