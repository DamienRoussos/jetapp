package com.example.jetapp.ui.restaurantdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetapp.domain.model.Restaurant

@Composable
fun RestaurantCardList(
    restaurants: List<Restaurant>,
    onSetFavourite: (Int) -> Unit,
) {
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