package com.example.jetapp.ui.features

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.example.jetapp.ui.heartshapefavourite.HeartShape

@Composable
fun ShowFavouriteRestaurantsButton(
    toggleFavourites: () -> Unit,
    showFavourites: Boolean,
    userPostCode: String,
    onFilterFavourites: (Boolean) -> Unit,
    onExitFilterFavourites: (String) -> Unit,
) {
    IconButton(onClick = {
        toggleFavourites()
        if (showFavourites) {
            onExitFilterFavourites(userPostCode)
        } else {
            onFilterFavourites(showFavourites)
        }
    }) {
        HeartShape(showFavourites)
    }
}