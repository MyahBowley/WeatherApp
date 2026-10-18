package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun AppSettings() {
    // GRADIENT FOR BACKGROUND
    val gradientColors = listOf(
        Color(0xFF17203F),
        Color(0xFF423A8E),
        Color(0xFF7A52AB),
        Color(0xFF933EA6)
    )
    // BACKGROUND OF SCREEN
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = gradientColors))
    ) {
        // SCREEN CONTENT

        // (Gear icon) "Settings"
        Row(modifier = Modifier.padding(horizontal = 30.dp, vertical = 60.dp)){
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Location icon",
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = " Settings",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold)
        }
    }
}