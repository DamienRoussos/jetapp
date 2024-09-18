package com.example.jetapp.data

data class Restaurant(
    val name: String,
    val outCode: String,
    val postCode: String,
    val cuisineType: List<CuisineType>,
    val rating: Double,
    val image: String,
)
