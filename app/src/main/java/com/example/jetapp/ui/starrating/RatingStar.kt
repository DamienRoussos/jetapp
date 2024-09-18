package com.example.jetapp.ui.starrating

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import kotlin.math.floor

@Composable
fun RatingStars(rating: Double) {
    Row {
        val filledStars = rating.toInt() // Directly convert to Int for flooring
        val remaining = rating - filledStars

        repeat(filledStars) {
            StarShape(filled = 1.0, strokeWidth = 0.dp) // Fully filled
        }
        if (remaining > 0) {
            StarShape(filled = remaining, strokeWidth = 0.dp) // Partially filled
        }
        repeat(5 - filledStars - (if (remaining > 0) 1 else 0)) {
            StarShape(filled = 0.0, strokeWidth = 2.dp) // Empty with stroke
        }
    }
}
