package com.example.weatherapp.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.filled.ViewDay
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.ui.screens.AppSettings

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
                containerColor = Color.Transparent,
                modifier = Modifier.height(95.dp),
                windowInsets = WindowInsets(0, 20, 0, 140),

            )
            {
                // ----- WeatherToday.kt -----
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ViewDay,
                            contentDescription = "Calender day logo", // alt
                            modifier = Modifier.size(35.dp)
                        )
                    },
//                    label = { Text("Today") },
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

                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,

                        unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurface,

                        indicatorColor = MaterialTheme.colorScheme.primary

                    )
                )

                // ----- Forecast.kt -----
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Calender week logo", // alt
                            modifier = Modifier.size(35.dp)
                        )
                    },
//                    label = { Text("Forecast") },
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

                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,

                        unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurface,

                        indicatorColor = MaterialTheme.colorScheme.primary

                    )
                )


                // ----- AppSettings.kt -----
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Gear logo", // alt
                            modifier = Modifier.size(35.dp)
                        )
                    },
//                    label = { Text("Settings") },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        navController.navigate(route = "AppSettings") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,

                        unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurface,

                        indicatorColor = MaterialTheme.colorScheme.primary

                    )
                )

            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "WeatherToday",
//            modifier = Modifier.padding(innerPadding)

        ) {
            composable(route = "WeatherToday") {
                WeatherToday()
            }
            composable(route = "Forecast") {
                Forecast()
            }
            composable(route = "AppSettings") {
                AppSettings()
            }
        }
        }

}