package com.example.jetapp.ui.helpers

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable

@Composable
fun RatingStars(rating: Float) {
    Row {
        repeat(5) { index ->
            StarShape(filled = index < rating)
        }
    }
}