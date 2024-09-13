package com.example.jetapp.ui.restaurantdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetapp.ui.data.RestaurantModel

@Composable
fun RestaurantImage(
    restaurant: RestaurantModel,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(restaurant.image),
        contentDescription = null,
        modifier = modifier
            .size(80.dp)
            .shadow(4.dp, RoundedCornerShape(4.dp))
            .clip(RoundedCornerShape(4.dp)),
        contentScale = ContentScale.Crop,
    )
}