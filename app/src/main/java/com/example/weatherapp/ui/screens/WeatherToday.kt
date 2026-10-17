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

// This will store today's current weather

@Composable
fun WeatherToday() {
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


        // The current location, temperature, and weather type
        // A translucent box that horizontally displays the weather at different times through the day

        // Looks like:
        //
        //      location icon Halifax
        //              7c
        //          Cloudy icon
        //             Cloudy
        // ------------------------------
        // | 11 am    cloud icon    11c |
        // | 12 pm    cloud icon    11c |
        // | 01 pm    rain icon     09c |

        Text(
            text = "Today's Weather",
            style = MaterialTheme.typography.displayLarge
        )
    }
}