package com.example.jetapp.ui.restaurantpage

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.ui.parameterprovider.RestaurantModelParameterProvider
import com.example.jetapp.ui.theme.JetAppTheme

@Composable
fun RestaurantPage(
    restaurant: Restaurant,
    modifier: Modifier = Modifier,
) {

}

@Preview(showBackground = true)
@Composable
fun RestaurantPagePreview(
    @PreviewParameter(
        RestaurantModelParameterProvider::class
    )
    model: Restaurant,
) {
    JetAppTheme {
        RestaurantPage(model)
    }
}