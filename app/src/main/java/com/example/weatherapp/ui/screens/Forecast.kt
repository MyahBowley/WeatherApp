package com.example.weatherapp.ui.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.weatherapp.ui.theme.WeatherAppTheme

// This will store the weather forecast for the week

@Composable
fun Forecast() {
    WeatherAppTheme {
        Text(
            text = "Weekly Forecast",
            style = MaterialTheme.typography.displayLarge
        )
    }
}