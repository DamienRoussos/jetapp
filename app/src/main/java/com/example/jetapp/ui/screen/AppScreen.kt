package com.example.jetapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetapp.data.datasource.MockData
import com.example.jetapp.domain.model.Restaurant
import com.example.jetapp.ui.heartshapefavourite.HeartShape
import com.example.jetapp.ui.restaurantdetails.RestaurantCard
import com.example.jetapp.ui.restaurantsearch.RestaurantSearch
import com.example.jetapp.ui.theme.JetAppTheme

@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
    onPostCodeChange: (String) -> Unit,
    restaurants: List<Restaurant>,
    onSetFavourite: (Int) -> Unit,
) {
    var userPostCode by remember { mutableStateOf("Enter your postcode") }

    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = modifier.padding(4.dp))
            HeartShape(false)
            Spacer(modifier = modifier.padding(4.dp))
            RestaurantSearch(
                userPostCode = userPostCode,
                onPostCodeEnter = { updatedPostcode ->
                    userPostCode = updatedPostcode
                    onPostCodeChange(updatedPostcode)
                },
            )
        }
        LazyColumn(
            modifier = Modifier.padding(16.dp),
        ) {
            items(restaurants.size) { itemPosition ->
                RestaurantCard(
                    restaurant = restaurants[itemPosition],
                    onSetFavourite = onSetFavourite
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    JetAppTheme {
        AppScreen(
            onPostCodeChange = {},
            restaurants = MockData().loadMockData(),
            onSetFavourite = {})
    }
}