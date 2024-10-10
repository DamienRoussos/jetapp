package com.example.jetapp.data.datasource

import com.example.jetapp.data.api.JetApi
import com.example.jetapp.data.mapper.RestaurantMapper
import com.example.jetapp.data.model.RestaurantResponse
import com.example.jetapp.data.model.RestaurantResponseContainer
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test


class RestaurantRemoteDataSourceImplTest {
    private val restaurantMapper: RestaurantMapper = mockk()
    private val jetApi: JetApi = mockk()
    private val dataSource = RestaurantRemoteDataSourceImpl(restaurantMapper)

    @Test
    fun `SHOULD call the API WHEN a postcode is provided`() = runTest {
        // Given
        val postcode = "EC4M 7DY"
        val restaurantResponse = listOf(
            mockk<RestaurantResponse>(),
            mockk<RestaurantResponse>(),
            mockk<RestaurantResponse>()
        )
        val mappedRestaurants = listOf(
            mockk<RestaurantResponse>(),
            mockk<RestaurantResponse>(),
            mockk<RestaurantResponse>()
        ).map{restaurantMapper.map(it)}

        // OR
//        val mappedRestaurants = listOf(
//            mockk<Restaurant>(),
//            mockk<Restaurant>(),
//            mockk<Restaurant>()
//        )

        coEvery { jetApi.getRestaurantsByPostCode(postcode) } returns RestaurantResponseContainer(
            restaurantResponse
        )
        every { restaurantMapper.map(any<RestaurantResponse>()) } returnsMany mappedRestaurants

        val dataSource = RestaurantRemoteDataSourceImpl(restaurantMapper)
        // When
        dataSource.getRestaurantsByPostCode(postcode)

        // Then
        coVerify { jetApi.getRestaurantsByPostCode(postcode) }

    }

    @Test
    fun `SHOULD map the response from the API using the Mapper and sort the results`() {

    }
}
