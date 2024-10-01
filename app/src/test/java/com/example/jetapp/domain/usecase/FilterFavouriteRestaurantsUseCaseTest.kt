package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.model.CuisineType
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class FilterFavouriteRestaurantsUseCaseTest {

    private val repository: RestaurantRepository = mockk(relaxed = true)
    private val useCase = FilterFavouriteRestaurantsUseCase(repository)

    @Test
    fun `SHOULD call function from repository WHEN useCase is called`() {
        // Given

        // When
        useCase()

        // Then
        verify { repository.filterFavouriteRestaurants() }
    }

    @Test
    fun `SHOULD return favourite restaurants from repository WHEN useCase is called`() {
        // Given
        val restaurants = mockedRestaurants
        val expectedResult = favouriteRestaurants.sortedBy { it.name }
        every { repository.filterFavouriteRestaurants() } returns restaurants

        // When
        useCase()

        // Then
        verify { repository.filterFavouriteRestaurants() }
    }

    companion object {
        private val mockedRestaurants = listOf(
            Restaurant(
                1,
                "Pret A Manger - Paternoster Square",
                "EC4M",
                "EC4M 7DY",
                listOf(
                    CuisineType("Sandwiches"),
                    CuisineType("Coffee")
                ),
                5.0,
                "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/114934.gif",
                isFavourite = true
            ),
            Restaurant(
                2,
                "Starbucks - Paternoster Square",
                "EC4M",
                "EC4M 7DX",
                listOf(
                    CuisineType("Breakfast"),
                    CuisineType("Coffee"),
                    CuisineType("Lunch")
                ),
                5.0,
                "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/147838.gif",
                isFavourite = false
            ),
            Restaurant(
                3,
                "Gourmet Burger Kitchen - St Pauls",
                "EC4M",
                "EC4M 8AL",
                listOf(
                    CuisineType("Burgers"),
                    CuisineType("American")
                ),
                4.1,
                "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/130434.gif",
                isFavourite = true
            )
        )
        private val favouriteRestaurants = listOf(
            Restaurant(
                3,
                "Gourmet Burger Kitchen - St Pauls",
                "EC4M",
                "EC4M 8AL",
                listOf(
                    CuisineType("Burgers"),
                    CuisineType("American")
                ),
                4.1,
                "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/130434.gif",
                isFavourite = true
            ),
            Restaurant(
                1,
                "Pret A Manger - Paternoster Square",
                "EC4M",
                "EC4M 7DY",
                listOf(
                    CuisineType("Sandwiches"),
                    CuisineType("Coffee")
                ),
                5.0,
                "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/114934.gif",
                isFavourite = true
            )
        )
    }
}

