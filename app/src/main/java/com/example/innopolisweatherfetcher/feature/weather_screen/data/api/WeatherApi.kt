package com.example.innopolisweatherfetcher.feature.weather_screen.data.api

import com.example.innopolisweatherfetcher.feature.weather_screen.data.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/weather")
    fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") appId: String = "",
        @Query("units") units: String = "metric"
    ): WeatherModel
}