package com.example.innopolisweatherfetcher.feature.weather_screen.data.api

class WeatherRepositoryImpl(val source: WeatherRemoteSource) : WeatherRepository {
    override fun getWeather(): String {
        return "Weather"
    }
}