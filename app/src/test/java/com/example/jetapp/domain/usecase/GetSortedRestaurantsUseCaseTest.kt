package com.example.jetapp.domain.usecase

import com.example.jetapp.domain.model.CuisineType
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GetSortedRestaurantsUseCaseTest {

    private val repository: RestaurantRepository = mockk(relaxed = true)
    private val useCase = GetSortedRestaurantsUseCase(repository)
    
    @Test
    fun `SHOULD call function from repository WHEN useCase is called`() {
        // Given
        val postCode = "postCode"

        // When
        useCase(postCode)

        // Then
        verify { repository.getRestaurantsByPostCode(postCode) }
    }

    @Test
    fun `SHOULD return sorted restaurants from repository WHEN useCase is called`() {
        // Given
        val restaurants = mockedRestaurants
        val expectedResult = sortedRestaurants
        val postCode = "postCode"
        every { repository.getRestaurantsByPostCode(postCode) } returns restaurants

        // When
        val result = useCase(postCode)

        // Then
        assertEquals(expectedResult,result)
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
                isFavourite = false
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
                isFavourite = false
            )
        )
        private val sortedRestaurants = listOf(
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
                isFavourite = false
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
                isFavourite = false
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
            )
        )
    }
}