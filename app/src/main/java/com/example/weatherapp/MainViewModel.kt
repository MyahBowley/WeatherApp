package com.example.weatherapp

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.WeatherApi
import com.example.weatherapp.data.dao.Weather
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.location.Location

class MainViewModel (app: Application) : AndroidViewModel(app) {
    // Using Google's location provider to find where the phone is
    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(app)

    // storing weather data (initially set at null because it hasn't loaded yet) NOTE: mutableStateOf automatically updates screen when the value changes
    var weather: Weather? by mutableStateOf<Weather?>(null)
        private set

    // storing current location
    var location by mutableStateOf<Location?>(null)
        private set // other classes can read but can't modify it

    @SuppressLint("MissingPermission") // silence warning
    fun refreshLocation() { // Function to get user's current location
        fusedLocationClient //asking gps for current location
            .getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null) // use gps if possible for best accuracy
            .addOnSuccessListener { result -> // when the gps returns a location...
                location = result // save the result in location variable
                val lat = location?.latitude; // getting lat if location is not null
                val long = location?.longitude;

                // sending lat and long to getWeather()
                getWeather("$lat,$long")

                val latlng = "lat: ${location?.latitude}, lng: ${location?.longitude}"
                Log.i("MainViewModel", "Phone is location at $latlng.")
            }
    }

    // RETROFIT SETUP
    // creating a Retofit client
    private val api = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/") // root address for all API calls
        .addConverterFactory(GsonConverterFactory.create()) // converts JSON responses into Kotlin objects automatically
        .build()
        .create(WeatherApi::class.java) // Interface

    init {
        //  initializations go here
//        refreshLocation()

        getWeather("Halifax")
    }

    fun getWeather(query: String){
        // Launch Co-Routine
        viewModelScope.launch {
            // call API (sends request, waits for response, converts JSON into weather object, stores it in weather
            weather = api.getWeather(q=query)

            // log for testing
            Log.d(
                "Weather",
                "Temp: ${weather?.current?.tempC}"
            )
        }
    }

}