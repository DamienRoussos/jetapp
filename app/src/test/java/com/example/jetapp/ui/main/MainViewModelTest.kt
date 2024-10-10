package com.example.jetapp.ui.main

import com.example.jetapp.domain.model.CuisineType
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository
import com.example.jetapp.domain.usecase.FilterFavouriteRestaurantsUseCase
import com.example.jetapp.domain.usecase.GetRemoteRestaurantsByPostCodeUseCase
import com.example.jetapp.domain.usecase.GetSortedRestaurantsUseCase
import com.example.jetapp.domain.usecase.ToggleFavouriteUseCase
import com.example.jetapp.utils.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val repository: RestaurantRepository = mockk()
    private val getSortedRestaurants: GetSortedRestaurantsUseCase = mockk()
    private val toggleFavouriteUseCase: ToggleFavouriteUseCase = mockk()
    private val filterFavouriteRestaurants: FilterFavouriteRestaurantsUseCase = mockk()
    private val searchRestaurantsByPostCode: GetRemoteRestaurantsByPostCodeUseCase = mockk()
    private val viewModel = MainViewModel(
        repository = repository,
        getSortedRestaurants = getSortedRestaurants,
        toggleFavouriteUseCase = toggleFavouriteUseCase,
        filterFavouriteRestaurants = filterFavouriteRestaurants,
        searchRestaurantsByPostCode = searchRestaurantsByPostCode
    )

    @Test
    fun `SHOULD call get sorted restaurants WHEN search restaurant by post code is called`() {
        // Given
        val restaurants: List<Restaurant> = mockk(relaxed = true)
        val postCode = "postCode"
        every { getSortedRestaurants(postCode) } returns restaurants

        // When
        viewModel.searchRestaurantByPostCode(postCode)

        // Then
        assertEquals(restaurants, viewModel.restaurantsState.value)
    }

//    @Test
//    fun `SHOULD toggle isFavourite status of the restaurant WHEN a matching restaurantId is passed`() {
//        // Given
//        val restaurantId = 1
//
//        // When
//
//
//        // Then
//
//    }
//
//    @Test
//    fun `SHOULD not modify isFavourite status of other restaurants`() {
//
//    }
//
//    @Test
//    fun `SHOULD update restaurantsState with the modified list of restaurants`() {
//
//    }

    @Test
    fun `SHOULD call filterFavouriteRestaurants WHEN isFavourite is true`() {
        // Given
        val isFavourite = true
        val restaurants: List<Restaurant> = mutableListOf(mockk<Restaurant>(),mockk<Restaurant>(),mockk<Restaurant>())
        every { filterFavouriteRestaurants() } returns restaurants

        // When
        viewModel.filterFavouriteRestaurants(isFavourite)

        // Then
        assertEquals(restaurants, viewModel.restaurantsState.value)
    }

    @Test
    fun `SHOULD call getSortedRestaurants WHEN isFavourite is false`() {
        // Given
        val isFavourite = false
        val restaurants: List<Restaurant> = mutableListOf(mockk<Restaurant>(),mockk<Restaurant>(),mockk<Restaurant>())
        every { getSortedRestaurants("") } returns restaurants

        // When
        viewModel.filterFavouriteRestaurants(isFavourite)

        // Then
        assertEquals(restaurants, viewModel.restaurantsState.value)

    }

    @Test
    fun `SHOULD post value returned by searchRestaurantByPostCode WHEN there is no exception`() =
        runTest {
            // Given
            val postCode = "postCode"
            val mockedRestaurants: List<Restaurant> = mockk(relaxed = true)
            coEvery { searchRestaurantsByPostCode(postCode) } returns mockedRestaurants

            // When
            viewModel.getRemoteRestaurantsByPostCode(postCode)

            // Then
            assertEquals(mockedRestaurants, viewModel.remoteRestaurantState.value)
        }

    @Test
    fun `SHOULD not post value returned by searchRestaurantByPosCode when there is an exception`() {
        // Given
        val postCode = "postCode"
        coEvery { searchRestaurantsByPostCode(postCode) } throws Exception()

        // When
        viewModel.getRemoteRestaurantsByPostCode(postCode)

        // Then
        assertEquals(emptyList<List<Restaurant>>(), viewModel.remoteRestaurantState.value)
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
    }
}