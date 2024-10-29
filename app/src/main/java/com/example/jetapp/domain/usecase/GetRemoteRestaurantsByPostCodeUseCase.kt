package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.repository.RestaurantRepository
import javax.inject.Inject

class GetRemoteRestaurantsByPostCodeUseCase @Inject constructor(
    private val repository: RestaurantRepository,
) {
    suspend operator fun invoke(postCode: String) =
        repository.searchRemoteRestaurantsByPostCode(postCode)
}

