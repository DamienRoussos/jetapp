package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.repository.RestaurantRepository
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Test
import kotlinx.coroutines.test.runTest

class GetRemoteRestaurantsByPostCodeUseCaseTest {

    private val repository: RestaurantRepository = mockk(relaxed = true)
    private val useCase = GetRemoteRestaurantsByPostCodeUseCase(repository)

    @Test
    fun `SHOULD call function from repository WHEN useCase is called`() {
        runTest {
            // Given
            val postCode = "postCode"

            // When
            useCase(postCode)

            // Then
            coVerify { repository.getRestaurantsByPostCode(postCode) }
        }
    }

}