package com.example.weatherapp.data.dao
//package com.example.weatherapp.data.dao

import com.google.gson.annotations.SerializedName

data class Weather(
    val location: LocationData,
    val current: CurrentWeather,
    val forecast: Forecast

)

data class LocationData (
    val name: String,
    val region: String,
    val lat: Float,
    val lon: Float
)

data class CurrentWeather (

    @SerializedName("temp_c")
    val tempC: Float,
    @SerializedName("temp_f")
    val tempF: Float,
    @SerializedName("is_day")
    val isDay: Int,

    val condition: Condition
)

data class Condition (
    val text: String,
    val icon: String
)

data class Forecast(
    val forecastday: List<ForecastDay>
)

data class ForecastDay(
    val date: String,
    val hour: List<HourForecast>
)

data class HourForecast(

    val time: String,

    @SerializedName("temp_c")
    val tempC: Float,

    val condition: Condition
)