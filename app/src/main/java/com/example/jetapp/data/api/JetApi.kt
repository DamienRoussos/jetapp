package com.example.jetapp.data.api

import com.example.jetapp.data.model.RestaurantResponseContainer
import retrofit2.http.GET
import retrofit2.http.Path

interface JetApi {
    @GET("bypostcode/{postcode}")
    suspend fun getRestaurantsByPostCode(
        @Path("postcode") postcode: String,
    ): RestaurantResponseContainer
}