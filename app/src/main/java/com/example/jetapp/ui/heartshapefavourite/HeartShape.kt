package com.example.jetapp.ui.heartshapefavourite

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.example.jetapp.ui.theme.JetOrange

@Composable
fun HeartShape(
    isFavourite: Boolean,
) {
    Icon(
        imageVector = if (isFavourite) Icons.Filled.Favorite
        else Icons.Filled.FavoriteBorder,
        contentDescription = "favourite",
        tint = JetOrange,
    )
}
