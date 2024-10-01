package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.repository.RestaurantRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ToggleFavouriteUseCaseTest {

    private val repository: RestaurantRepository = mockk(relaxUnitFun = true)
    private val useCase = ToggleFavouriteUseCase(repository)

    @Test
    fun `SHOULD call function from repository WHEN useCase is called`() {
        // Given
        val restaurantId = 1

        // When
        useCase(restaurantId)

        // Then
        verify { repository.toggleRestaurantIsFavourite(restaurantId) }
    }
}
