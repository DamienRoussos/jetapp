package com.example.jetapp.ui.restaurantdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetapp.data.RestaurantModel
import com.example.jetapp.ui.starrating.RatingStars
import com.example.jetapp.ui.parameterprovider.RestaurantModelParameterProvider
import com.example.jetapp.ui.theme.JetAppTheme

@Composable
fun RestaurantDetails(
    restaurant: RestaurantModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(4.dp)
            .fillMaxSize(0.75f),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(restaurant.name),
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            modifier = Modifier.padding(4.dp),
            style = TextStyle(
                fontSize = 16.sp,
            )
        )
        Text(
            text = stringResource(restaurant.cuisineType),
            modifier = Modifier.padding(8.dp),
            style = TextStyle(
                fontSize = 12.sp
            )
        )
        Row {
            Text(
                text = stringResource(restaurant.rating),
                modifier = Modifier.padding(4.dp),
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
            Spacer(modifier.padding(4.dp))
            RatingStars(restaurant.rating.toFloat())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantDetailsPreview(
    @PreviewParameter(
        RestaurantModelParameterProvider::class)
    model: RestaurantModel
) {
    JetAppTheme {
        RestaurantDetails(model)
    }
}