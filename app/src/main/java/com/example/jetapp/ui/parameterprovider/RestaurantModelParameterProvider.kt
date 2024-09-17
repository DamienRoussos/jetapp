package com.example.jetapp.ui.parameterprovider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.jetapp.data.MockData
import com.example.jetapp.data.RestaurantModel

class RestaurantModelParameterProvider: PreviewParameterProvider<RestaurantModel> {
    override val values: Sequence<RestaurantModel>
        get() = MockData().loadMockData().asSequence()

}