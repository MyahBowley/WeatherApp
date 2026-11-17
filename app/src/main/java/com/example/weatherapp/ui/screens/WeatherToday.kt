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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.ui.theme.MedPurple
import com.example.weatherapp.ui.theme.WeatherAppTheme

// This will store today's current weather

@Composable
fun WeatherToday(viewModel: MainViewModel) {

    val weather = viewModel.weather

    // GRADIENT FOR BACKGROUND
    val gradientColors = listOf(
        Color(0xFF17203F),
        Color(0xFF423A8E),
        Color(0xFF7A52AB),
        Color(0xFF933EA6)
    )

    val boxGradient = listOf(
//        Color(0xFF3D2C8D),
        Color(0xFF493292),
        Color(0xFF6E419F),
        Color(0xFF9A38AA),
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
            weather?.let {
                Text(
                    text = it.location.name,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        //          (Cloudy icon)
        //               7°C

        // grab the 24 hourly forecast entries
        val hourlyForecast = weather
            ?.forecast
            ?.forecastday
            ?.firstOrNull()
            ?.hour

//        if (weather == null) {
//
//            Text(
//                text = "Loading weather...",
//                color = Color.White
//            )
//
//        } else {
//
//            // weather UI
//        }
        Column(
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 100.dp),
            verticalArrangement = Arrangement.SpaceBetween,       // Centers items vertically (Main Axis)
            horizontalAlignment = Alignment.CenterHorizontally // Centers items horizontally (Cross Axis)
        ) {
            // choosing icon based on weather condition
            val icon = when {
                weather?.current?.condition?.text?.contains("sun", true) == true ->
                    Icons.Default.WbSunny

                weather?.current?.condition?.text?.contains("rain", true) == true ->
                    Icons.Default.Shower

                weather?.current?.condition?.text?.contains("storm", true) == true ->
                    Icons.Default.Thunderstorm

                else ->
                    Icons.Default.Cloud
            }

            // displaying the icon
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(80.dp))

            // Temperature
            weather?.let {
                Text(
                    text = "${it.current.tempC}°C",
                    color = Color.White,
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
            // weather description
            weather?.let {
                Text(
                    text = it.current.condition.text,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge
                )
            }
//            Text(
//                text = "7°C",
//                color = Color.White,
//                style = MaterialTheme.typography.displayLarge,
//                fontWeight = FontWeight.SemiBold)

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
                    hourlyForecast?.take(12)?.forEach { hour ->
                      // assigning icons to api results
                        val icon = when {
                            hour.condition.text.contains("sun", true) ->
                                Icons.Default.WbSunny

                            hour.condition.text.contains("rain", true) ->
                                Icons.Default.Shower

                            hour.condition.text.contains("storm", true) ->
                                Icons.Default.Thunderstorm

                            else ->
                                Icons.Default.Cloud
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = hour.time.takeLast(5),
                                color = Color.White
                            )

                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = Color.White
                            )

                            Text(
                                text = hour.condition.text,
                                color = Color.White
                            )

                            Text(
                                text = "${hour.tempC}°",
                                color = Color.White
                            )
                        }
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