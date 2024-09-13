package com.example.jetapp.ui.restaurantdetails


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.jetapp.R
import com.example.jetapp.ui.data.RestaurantModel
import com.example.jetapp.ui.theme.JetOrange

@Composable
fun RestaurantCard(
    restaurant: RestaurantModel,
) {
    Card(
        modifier = Modifier.padding(bottom = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.white)),
        border = BorderStroke(1.dp, JetOrange)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            RestaurantDetails(
                restaurant = restaurant,
            )
            RestaurantImage(
                restaurant = restaurant,
            )
        }
    }
}