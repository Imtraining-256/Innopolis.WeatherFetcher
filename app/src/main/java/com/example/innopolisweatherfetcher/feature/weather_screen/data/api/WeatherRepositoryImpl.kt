package com.example.innopolisweatherfetcher.feature.weather_screen.data.api

class WeatherRepositoryImpl(private val source: WeatherRemoteSource) : WeatherRepository {
    override suspend fun getWeather(): String {
        return source.getWeather().main.temp
    }
}