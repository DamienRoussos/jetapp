package com.example.jetapp.data.datasource

import com.example.jetapp.data.api.JetApi
import com.example.jetapp.data.mapper.RestaurantMapper
import com.example.jetapp.data.model.RestaurantResponse
import com.example.jetapp.data.model.RestaurantResponseContainer
import com.example.jetapp.domain.model.Restaurant
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test


class RestaurantRemoteDataSourceImplTest {

    private val restaurantMapper : RestaurantMapper = mockk()
    private val jetApi: JetApi = mockk()
    private val dataSource: RestaurantRemoteDataSource = RestaurantRemoteDataSourceImpl(restaurantMapper, jetApi)

    @Test
    fun `SHOULD call the API WHEN a postcode is provided and mapped the response`() = runTest {
        // Given
        val postCode = "SW1A 1AA"
        val restaurantResponse1: RestaurantResponse = mockk()
        val restaurantResponse2: RestaurantResponse = mockk()
        val restaurantResponseList: List<RestaurantResponse> = listOf(restaurantResponse1,  restaurantResponse2)
        val restaurantResponseContainer: RestaurantResponseContainer = mockk {
            every { restaurants } returns restaurantResponseList
        }

        coEvery { jetApi.getRestaurantsByPostCode(postCode) } returns restaurantResponseContainer
        val expectedRestaurant1: Restaurant = mockk()
        val expectedRestaurant2: Restaurant = mockk()
        every { restaurantMapper.map(restaurantResponse1)} returns expectedRestaurant1
        every { restaurantMapper.map(restaurantResponse2)} returns expectedRestaurant2

        // When

        val result = dataSource.getRestaurantsByPostCode(postCode)

        // Then
        assertEquals(listOf(expectedRestaurant1, expectedRestaurant2), result)
    }
}
