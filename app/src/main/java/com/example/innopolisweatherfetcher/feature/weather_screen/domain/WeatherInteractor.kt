package com.example.innopolisweatherfetcher.feature.weather_screen.domain

import com.example.innopolisweatherfetcher.base.attempt
import com.example.innopolisweatherfetcher.feature.weather_screen.data.api.WeatherRepository

class WeatherInteractor(private val weatherRepository: WeatherRepository) {
    suspend fun getWeather() = attempt {
        weatherRepository.getWeather()
    }
}