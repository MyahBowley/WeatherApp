package com.example.weatherapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Today
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// Screens
import com.example.weatherapp.ui.screens.Forecast
import com.example.weatherapp.ui.screens.WeatherToday


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    var selectedIndex by remember {mutableIntStateOf(0)} // default set to 0 (This changes based on what the user is selecting

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                windowInsets = NavigationBarDefaults.windowInsets
            )
            {
                // ----- WeatherToday.kt -----
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Today,
                            contentDescription = "Today's Weather"
                        )
                    },
                    label = { Text("Today") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(route = "WeatherToday") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    }
                )

                // ----- Forecast.kt -----
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Weekly Forecast"
                        )
                    },
                    label = { Text("Forecast") },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(route = "Forecast") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    }
                )


            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "WeatherToday",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = "WeatherToday") {
                WeatherToday()
            }
            composable(route = "Forecast") {
                Forecast()
            }
        }
        }

}