package com.example.jetapp.data.mapper

import com.example.jetapp.data.model.RestaurantCuisineResponse
import com.example.jetapp.domain.model.CuisineType
import com.example.jetapp.util.Mapper

class CuisineMapper : Mapper<RestaurantCuisineResponse, CuisineType> {
    override fun map(input: RestaurantCuisineResponse) = CuisineType(
        name = input.name
    )
}