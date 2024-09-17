package com.example.jetapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RestaurantModel(
    @StringRes val name: Int,
    @StringRes val cuisineType: Int,
    @StringRes val rating: Int,
    @DrawableRes val image: Int,
)
