package com.example.jetapp.ui.parameterprovider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.jetapp.data.datasource.MockData
import com.example.jetapp.domain.model.Restaurant

class RestaurantModelParameterProvider : PreviewParameterProvider<Restaurant> {
    override val values: Sequence<Restaurant>
        get() = MockData().loadMockData().asSequence()

}