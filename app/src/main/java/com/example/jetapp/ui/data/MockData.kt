package com.example.jetapp.ui.data

import com.example.jetapp.R

class MockData {
    fun loadMockData(): List<RestaurantModel> {
        return listOf(
            RestaurantModel(R.string.resto1_name, R.string.resto1_cuisines, R.string.resto1_rating, R.drawable.imageresto1),
            RestaurantModel(R.string.resto2_name, R.string.resto2_cuisines, R.string.resto2_rating, R.drawable.imageresto2),
            RestaurantModel(R.string.resto3_name, R.string.resto3_cuisines, R.string.resto3_rating, R.drawable.imageresto3),
            RestaurantModel(R.string.resto4_name, R.string.resto4_cuisines, R.string.resto4_rating, R.drawable.imageresto4),
            RestaurantModel(R.string.resto5_name, R.string.resto5_cuisines, R.string.resto5_rating, R.drawable.imageresto5),
            RestaurantModel(R.string.resto6_name, R.string.resto6_cuisines, R.string.resto6_rating, R.drawable.imageresto6),
            RestaurantModel(R.string.resto7_name, R.string.resto7_cuisines, R.string.resto7_rating, R.drawable.imageresto7),
            RestaurantModel(R.string.resto8_name, R.string.resto8_cuisines, R.string.resto8_rating, R.drawable.imageresto8),
            RestaurantModel(R.string.resto9_name, R.string.resto9_cuisines, R.string.resto9_rating, R.drawable.imageresto9),
        )
    }
}


