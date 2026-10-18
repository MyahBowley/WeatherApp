package com.example.weatherapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Shower
import androidx.compose.material.icons.filled.Thunderstorm
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.WeatherAppTheme

// This will store the weather forecast for the week

@Composable
fun Forecast() {
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

        // A translucent box that horizontally displays the weather at different times through the week:
        // Day    Icon    High / Low

        // Looks like:
        //
        //     (location icon) Halifax
        //
        //         7-Day Forecast
        // ------------------------------
        // | Today  cloud icon    11c 03c |
        // | Mon    sunny icon    11c 03c |
        // | Tue    rain icon     09c 00c |


        // (location icon) "Halifax"
        Row(modifier = Modifier.padding(horizontal = 30.dp, vertical = 60.dp)){
            Icon(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = "Location icon",
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = " Halifax",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold)
        }

        Column(
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 100.dp),
            verticalArrangement = Arrangement.SpaceBetween,       // Centers items vertically (Main Axis)
            horizontalAlignment = Alignment.CenterHorizontally // Centers items horizontally (Cross Axis)
        ) {
            Spacer(modifier = Modifier.height(24.dp)) // Adds space

            //         7-Day Forecast
            // ------------------------------
            // | Today  cloud icon    11c 03c |
            // | Mon    sunny icon    11c 03c |
            // | Tue    rain icon     09c 00c |

            OutlinedCard(
                colors = CardDefaults.outlinedCardColors(containerColor = Color.Transparent),
                border = BorderStroke(2.dp, color = Color.White)
            ) {
                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "7-Day Forecast")
                        Text(text = "H    L")
                    }

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        thickness = 1.5.dp,
                        color = MaterialTheme.colorScheme.outlineVariant
                    )

                    // -------------------- PLACEHOLDER DATA --------------------

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "Sun ")
                        Icon(
                            imageVector = Icons.Default.Cloud,
                            contentDescription = "Cloudy icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "5°  1°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "Mon")
                        Icon(
                            imageVector = Icons.Default.Cloud,
                            contentDescription = "Cloudy icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "8°  5°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "Tue ")
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Sunny icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "6°  3°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "Thu ")
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Sunny icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "4°  2°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "Fri   ")
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Sunny icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "3°  1°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "Sat  ")
                        Icon(
                            imageVector = Icons.Default.Cloud,
                            contentDescription = "Sunny icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "5°  2°")
                    }
                    // ----------------- END OF PLACEHOLDER DATA -----------------


                }
            }

        }
    }
}