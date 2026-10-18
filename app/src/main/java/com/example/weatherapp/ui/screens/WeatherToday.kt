package com.example.weatherapp.ui.screens

import android.R.attr.text
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shower
import androidx.compose.material.icons.filled.Thunderstorm
import androidx.compose.material.icons.filled.ViewDay
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.MedPurple
import com.example.weatherapp.ui.theme.WeatherAppTheme

// This will store today's current weather

@Composable
fun WeatherToday() {
    // GRADIENT FOR BACKGROUND
    val gradientColors = listOf(
        Color(0xFF17203F),
        Color(0xFF423A8E),
        Color(0xFF7A52AB),
        Color(0xFF933EA6)
//        Color(0xFF192240),
//        Color(0xFF2B2E62),
//        Color(0xFF3A377D),
//        Color(0xFF493C93),
//        Color(0xFF573F9F),
//        Color(0xFF6946AA),
//        Color(0xFF714FAA),
//        Color(0xFF7F51AA),
//        Color(0xFF824DA9),
//        Color(0xFF953AA7),
    )

    val boxGradient = listOf(
//        Color(0xFF3D2C8D),
        Color(0xFF493292),
        Color(0xFF6E419F),
        Color(0xFF9A38AA),

//        Color(0xFF9A38AA),
//        Color(0xFF6E419F),
//        Color(0xFF493292),
//        Color(0xFF3D2C8D),
    )
    // BACKGROUND OF SCREEN
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = gradientColors))
    ) {
        // SCREEN CONTENT

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

        //          (Cloudy icon)
        //               7°C

        Column(
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 100.dp),
            verticalArrangement = Arrangement.SpaceBetween,       // Centers items vertically (Main Axis)
            horizontalAlignment = Alignment.CenterHorizontally // Centers items horizontally (Cross Axis)
        ) {
            Icon(
                imageVector = Icons.Default.Cloud,
                contentDescription = "Cloudy icon",
                tint = Color.White,
                modifier = Modifier.size(80.dp))
            Text(
                text = "7°C",
                color = Color.White,
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(24.dp)) // Adds space

            // | Today           Month, Day |
            // |----------------------------|
            // | 11 am   cloud icon    11°C |
            // | 12 pm   cloud icon    11°C |
            // | 01 pm   rain icon      9°C |
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
                        Text(text = "Today")
                        Text(text = "Oct, 17")
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
                        Text(text = "  8am")
                        Icon(
                            imageVector = Icons.Default.Cloud,
                            contentDescription = "Cloudy icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "1°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "  9am")
                        Icon(
                            imageVector = Icons.Default.Cloud,
                            contentDescription = "Cloudy icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "2°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "10am")
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Sunny icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "4°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "11am")
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Sunny icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "5°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "12pm")
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Sunny icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "6°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "  1pm")
                        Icon(
                            imageVector = Icons.Default.Cloud,
                            contentDescription = "Sunny icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "7°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "  2pm")
                        Icon(
                            imageVector = Icons.Default.Cloud,
                            contentDescription = "Cloudy icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "5°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "  3pm")
                        Icon(
                            imageVector = Icons.Default.Cloud,
                            contentDescription = "Cloudy icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "4°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "  4pm")
                        Icon(
                            imageVector = Icons.Default.Shower,
                            contentDescription = "Rain icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "2°")
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "  5pm")
                        Icon(
                            imageVector = Icons.Default.Shower,
                            contentDescription = "Rain icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "2°")
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "  6pm")
                        Icon(
                            imageVector = Icons.Default.Shower,
                            contentDescription = "Rain icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "2°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "  7pm")
                        Icon(
                            imageVector = Icons.Default.Thunderstorm,
                            contentDescription = "Thunderstorm icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "1°")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(text = "  8pm")
                        Icon(
                            imageVector = Icons.Default.Thunderstorm,
                            contentDescription = "Thunderstorm icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(text = "1°")
                    }

                    // ----------------- END OF PLACEHOLDER DATA -----------------


                }
                }

            }
        }

        // (location icon) Halifax
        //
        //               7°C
        //          (cloud icon)
        //             Cloudy
        //
        // |-----------------------------|
        // | Today            Month, Day |
        // |-----------------------------|
        // | 11 am    cloud icon    11°C |
        // | 12 pm    cloud icon    11°C |
        // | 01 pm    rain icon     09°C |

}