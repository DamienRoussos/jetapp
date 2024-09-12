package com.example.jetapp.ui.restaurantdetails


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetapp.ui.data.RestaurantModel

@Composable
fun RestaurantCard(
    restaurant: RestaurantModel,
) {
    Card(modifier = Modifier.padding(bottom = 8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            RestaurantDetails(
                restaurant = restaurant,
                modifier = Modifier.weight(1f)
            )
            RestaurantImage(
                restaurant = restaurant,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}