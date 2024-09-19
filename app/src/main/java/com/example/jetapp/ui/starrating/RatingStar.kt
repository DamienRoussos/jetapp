package com.example.jetapp.ui.starrating

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetapp.ui.theme.JetOrange

@Composable
fun RatingStars(rating: Double) {
    val filledPercentage = (rating * 20).toFloat() // Convert to 0-100 scale

    Box(
        modifier = Modifier
            .width(80.dp)
            .height(16.dp) // Adjust height as needed
    ) {
        // Background filled rectangle (star color)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(JetOrange)
        )

        // Overlay filled rectangle (card color)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1 - filledPercentage / 100) // Fill based on rating
                .background(Color.White) // Or your card color
        )

        // Stars (transparent)
        Row(modifier = Modifier.fillMaxSize()) {
            repeat(5) {
                StarShape(filled = true, color = Color.Transparent)
            }
        }
    }
}