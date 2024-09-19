package com.example.jetapp.domain.model

data class Restaurant(
    val id: Int,
    val name: String,
    val outCode: String,
    val postCode: String,
    val cuisineType: List<CuisineType>,
    val rating: Double,
    val image: String,
    val isFavourite: Boolean,
)