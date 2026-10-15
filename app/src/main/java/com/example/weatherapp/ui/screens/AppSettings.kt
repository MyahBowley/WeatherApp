package com.example.weatherapp.ui.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun AppSettings() {
    WeatherAppTheme {
        // TO DO:
        // [ ] Add dark/light mode switch


        Text(
            text = "Settings",
            style = MaterialTheme.typography.displayLarge
        )
    }
}