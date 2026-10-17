package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun AppSettings() {
    // GRADIENT FOR BACKGROUND
    val gradientColors = listOf(
        Color(0xFF17203F),
        Color(0xFF423A8E),
        Color(0xFF7A52AB)
    )
    // BACKGROUND OF SCREEN
    Box(
        modifier = Modifier
            .fillMaxSize()
            // Use Brush.verticalGradient or Brush.horizontalGradient
            .background(brush = Brush.verticalGradient(colors = gradientColors))
    ) {
        // SCREEN CONTENT

        Text(
            text = "Settings",
            style = MaterialTheme.typography.displayLarge
        )
    }
}