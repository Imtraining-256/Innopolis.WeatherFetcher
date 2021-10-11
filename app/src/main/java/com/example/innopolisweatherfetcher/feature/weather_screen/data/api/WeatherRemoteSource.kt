package com.example.innopolisweatherfetcher.feature.weather_screen.data.api

import com.example.innopolisweatherfetcher.feature.weather_screen.data.model.WeatherModel

class WeatherRemoteSource(private val api: WeatherApi) {
    suspend fun getWeather(): WeatherModel {
        return api.getWeather("Moscow")
    }
}