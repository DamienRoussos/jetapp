package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetRemoteRestaurantsByPostCodeUseCaseTest {

    private val repository: RestaurantRepository = mockk(relaxed = true)
    private val useCase = GetRemoteRestaurantsByPostCodeUseCase(repository)

    @Test
    fun `SHOULD call function from repository WHEN useCase is called`() = runTest {
        // Given
        val postCode = "postCode"
        val restaurants: List<Restaurant> = mockk()
        coEvery { repository.searchRemoteRestaurantsByPostCode(postCode) } returns restaurants

        // When
        val result = useCase(postCode)

        // Then
        assertEquals(restaurants, result)
    }
}
