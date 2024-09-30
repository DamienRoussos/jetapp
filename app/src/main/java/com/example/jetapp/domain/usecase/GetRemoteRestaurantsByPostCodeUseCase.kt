package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.repository.RestaurantRepository

class GetRemoteRestaurantsByPostCodeUseCase(
    private val repository: RestaurantRepository,
) {
    suspend operator fun invoke(postCode: String) =
        repository.searchRemoteRestaurantsByPostCode(postCode)
}