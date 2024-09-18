package com.example.jetapp.ui.starrating

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetapp.ui.theme.JetOrange

@Composable
fun StarShape(filled: Double, strokeWidth: Dp) {
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

        if (filled > 0) {
            // Filled part
            drawPath(path, color = JetOrange)

            if (filled < 1) {
                // Unfilled part
                val clipPath = Path().apply {
                    addRect(
                        androidx.compose.ui.geometry.Rect(
                            offset = androidx.compose.ui.geometry.Offset(
                                x = size.width * filled.toFloat(),
                                y = 0f
                            ),
                            size = androidx.compose.ui.geometry.Size(
                                width = size.width * (1 - filled).toFloat(),
                                height = size.height
                            )
                        )
                    )
                }
                clipPath(clipPath) {
                    drawPath(
                        path,
                        color = Color.LightGray,
                        style = Stroke(width = strokeWidth.toPx()) // Use strokeWidth parameter
                    )
                }
            }
        } else {
            // Empty star
            drawPath(
                path,
                color = Color.LightGray,
                style = Stroke(width = strokeWidth.toPx()) // Use strokeWidth parameter
            )
        }
    }
}