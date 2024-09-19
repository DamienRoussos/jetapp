package com.example.jetapp.ui.starrating

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun StarShape(filled: Boolean, color: Color) {
    Canvas(modifier = Modifier.size(16.dp)) {
        val path = Path().apply {
            moveTo(size.width / 2f, 0f)
            lineTo(size.width * 0.62f, size.height * 0.38f)
            lineTo(size.width, size.height * 0.38f)
            lineTo(size.width * 0.69f, size.height * 0.62f)
            lineTo(size.width * 0.82f, size.height)
            lineTo(size.width / 2f, size.height * 0.76f)
            lineTo(size.width * 0.18f, size.height)
            lineTo(size.width * 0.31f, size.height * 0.62f)
            lineTo(0f, size.height * 0.38f)
            lineTo(size.width * 0.38f, size.height * 0.38f)
            close()
        }
        drawPath(path, color = color)
    }
}