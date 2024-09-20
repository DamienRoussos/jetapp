package com.example.jetapp.data.repository

import androidx.compose.runtime.internal.isLiveLiteralsEnabled
import com.example.jetapp.data.datasource.MockData
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.domain.repository.RestaurantRepository

class RestaurantRepositoryImpl : RestaurantRepository {
    private var data = MockData().loadMockData()

    override fun getRestaurantsByPostCode(postCode: String): List<Restaurant> {
        return data.filter { it.postCode.contains(postCode.uppercase()) }
    }

    //    adjust for favourite and unfavourite
    override fun setFavouriteRestaurant(restaurantId: Int) {

        data = data.map { restaurant ->
            if (restaurant.id == restaurantId) {
                restaurant.copy(isFavourite = !restaurant.isFavourite)
            } else {
                restaurant
            }
        }

//        val index = data.indexOfFirst { it.id == restaurantId }
//        var restaurant = data.find { it.id == restaurantId } ?: return
//        if(restaurant.isFavourite) {
//            restaurant = restaurant.copy(isFavourite = false)
//        } else {
//            restaurant = restaurant.copy(isFavourite = true)
//        }
//        data[index] = restaurant
    }

    override fun getFavouriteRestaurants(isFavourite: Boolean): List<Restaurant> {
        return data.filter { it.isFavourite }
    }
}