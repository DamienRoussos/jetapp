package com.example.jetapp.ui.main

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
import io.mockk.verify
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
    private val searchRestaurantsByPostCode: GetRemoteRestaurantsByPostCodeUseCase =
        mockk(relaxed = true)
    private val viewModel = MainViewModel(
        repository = repository,
        getSortedRestaurants = getSortedRestaurants,
        toggleFavouriteUseCase = toggleFavouriteUseCase,
        filterFavouriteRestaurants = filterFavouriteRestaurants,
        searchRestaurantsByPostCode = searchRestaurantsByPostCode
    )

    @Test
    fun `SHOULD call getSortedRestaurants WHEN searchRestaurantByPostCode is called`() {
        // Given
        val restaurants: List<Restaurant> = mockk(relaxed = true)
        val postCode = "postCode"
        every { getSortedRestaurants(postCode) } returns restaurants

        // When
        viewModel.searchRestaurantByPostCode(postCode)

        // Then
        assertEquals(restaurants, viewModel.restaurantsState.value)
    }

    @Test
    fun `SHOULD call filterFavouriteRestaurants WHEN isFavourite is true`() {
        // Given
        val isFavourite = true
        val restaurants: List<Restaurant> = mockk(relaxed = true)
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
        val restaurants: List<Restaurant> = mockk(relaxed = true)
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
}