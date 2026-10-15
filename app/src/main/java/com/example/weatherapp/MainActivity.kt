package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.SystemBarStyle.Companion.light
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation


import com.example.weatherapp.ui.theme.WeatherAppTheme

//
import com.example.weatherapp.ui.Navigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            navigationBarStyle = light(
                // containerColor = MaterialTheme.colorScheme.primary
                scrim = Color(0xFF923FA9).toArgb(),
                darkScrim = Color(0xFF923FA9).toArgb()

            )
        )
        setContent {
            WeatherAppTheme(dynamicColor = false) {
                Navigation()
            }
        }
    }
}