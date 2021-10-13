package com.example.innopolisweatherfetcher.feature.weather_screen.data.api

import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherDomainModel

interface WeatherRepository {
    suspend fun getWeather(): WeatherDomainModel
}