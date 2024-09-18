package com.example.jetapp.ui.parameterprovider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.jetapp.data.MockData
import com.example.jetapp.data.Restaurant

class RestaurantModelParameterProvider: PreviewParameterProvider<Restaurant> {
    override val values: Sequence<Restaurant>
        get() = MockData().loadMockData().asSequence()

}