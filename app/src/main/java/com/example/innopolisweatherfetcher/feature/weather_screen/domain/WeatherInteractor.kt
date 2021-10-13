package com.example.innopolisweatherfetcher.feature.weather_screen.domain

import com.example.innopolisweatherfetcher.feature.weather_screen.data.api.WeatherRepository
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherInteractor(private val weatherRepository: WeatherRepository) {
    suspend fun getWeather(): WeatherDomainModel {
        return weatherRepository.getWeather()
    }
}