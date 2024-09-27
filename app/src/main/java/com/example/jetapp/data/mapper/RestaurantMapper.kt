package com.example.jetapp.data.mapper

import com.example.jetapp.data.model.RestaurantResponse
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.util.Mapper

class RestaurantMapper(
    private val cuisineMapper: CuisineMapper = CuisineMapper()
): Mapper<RestaurantResponse, Restaurant> {
    override fun map(input: RestaurantResponse) = Restaurant(
        id = input.id.toInt(),
        name = input.name,
        outCode = "",
        postCode = input.postcode,
        cuisineType = input.cuisineTypes.map { cuisineMapper.map(it) },
        rating = input.ratingAverage,
        image = input.logoUrl,
        isFavourite = false
    )
}