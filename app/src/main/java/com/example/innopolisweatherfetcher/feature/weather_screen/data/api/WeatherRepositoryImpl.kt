package com.example.innopolisweatherfetcher.feature.weather_screen.data.api

import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherRepositoryImpl(private val source: WeatherRemoteSource) : WeatherRepository {
    override suspend fun getWeather(): WeatherDomainModel {
        return source.getWeather().toDomain()
    }
}