package com.example.jetapp.ui.restaurantsearch

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RestaurantSearch(
    userPostCode: String,
    onPostCodeEnter: (String) -> Unit
) {
    TextField(
        value = userPostCode,
        onValueChange = {
            updatedPostCode ->
                onPostCodeEnter(updatedPostCode)
        },
        modifier = Modifier.fillMaxWidth()
    )
}