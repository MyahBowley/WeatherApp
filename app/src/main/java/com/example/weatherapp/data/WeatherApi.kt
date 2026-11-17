package com.example.weatherapp.data
import com.example.weatherapp.data.dao.Weather

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast.json")
    suspend fun getWeather(
        @Query("key") key: String = "7d65f7cb4bd94b65bba180252261910",
        @Query("q") q: String,
        @Query("days") days: Int = 3
    ): Weather
}
