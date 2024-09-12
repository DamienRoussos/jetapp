package com.example.jetapp.ui.data

import com.example.jetapp.R

class MockData() {
    fun loadMockData(): List<RestaurantModel> {
        return listOf(
            RestaurantModel(R.string.resto1name, R.string.resto1cuisines, R.dimen.resto1rating, R.drawable.imageresto1),
            RestaurantModel(R.string.resto2name, R.string.resto2cuisines, R.dimen.resto2rating, R.drawable.imageresto2),
            RestaurantModel(R.string.resto3name, R.string.resto3cuisines, R.dimen.resto3rating, R.drawable.imageresto3),
            RestaurantModel(R.string.resto4name, R.string.resto4cuisines, R.dimen.resto4rating, R.drawable.imageresto4),
            RestaurantModel(R.string.resto5name, R.string.resto5cuisines, R.dimen.resto5rating, R.drawable.imageresto5),
            RestaurantModel(R.string.resto6name, R.string.resto6cuisines, R.dimen.resto6rating, R.drawable.imageresto6),
            RestaurantModel(R.string.resto7name, R.string.resto7cuisines, R.dimen.resto7rating, R.drawable.imageresto7),
            RestaurantModel(R.string.resto8name, R.string.resto8cuisines, R.dimen.resto8rating, R.drawable.imageresto8),
            RestaurantModel(R.string.resto9name, R.string.resto9cuisines, R.dimen.resto9rating, R.drawable.imageresto9),
        )
    }
}


