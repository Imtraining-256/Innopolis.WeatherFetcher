package com.example.innopolisweatherfetcher.feature.weather_screen.data.api

interface WeatherRepository {
    fun getWeather(): String
}