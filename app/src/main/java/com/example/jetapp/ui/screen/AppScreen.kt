package com.example.jetapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetapp.ui.data.MockData
import com.example.jetapp.ui.restaurantdetails.RestaurantCard
import com.example.jetapp.ui.restaurantsearch.RestaurantSearch
import com.example.jetapp.ui.theme.JetAppTheme

@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
) {
    var userPostCode by remember { mutableStateOf("Enter your postcode") }

    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(52.dp))
        RestaurantSearch(
            userPostCode = userPostCode,
            onPostCodeEnter = { updatedPostcode ->
                userPostCode = updatedPostcode
            },
        )
        LazyColumn(
            modifier = Modifier.padding(16.dp),
        ) {
            val restaurants = MockData().loadMockData()
            items(restaurants.size) { restaurant ->
                RestaurantCard(restaurants[restaurant])
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    JetAppTheme {
        AppScreen()
    }
}