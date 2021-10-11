package com.example.innopolisweatherfetcher.feature.weather_screen.data.api

interface WeatherRepository {
    suspend fun getWeather(): String
}