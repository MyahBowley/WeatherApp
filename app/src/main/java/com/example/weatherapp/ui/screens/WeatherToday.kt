package com.example.weatherapp.ui.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.weatherapp.ui.theme.WeatherAppTheme

// This will store today's current weather

@Composable
fun WeatherToday() {
    WeatherAppTheme {
        Text(
            text = "Today's Weather",
            style = MaterialTheme.typography.displayLarge
        )
    }
}