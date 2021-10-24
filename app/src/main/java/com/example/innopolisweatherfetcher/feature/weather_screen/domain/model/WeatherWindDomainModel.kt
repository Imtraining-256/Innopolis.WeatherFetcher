package com.example.innopolisweatherfetcher.feature.weather_screen.domain.model

data class WeatherWindDomainModel(
    val speed: Double,
    val deg: Double,
    val gust: Double
) {
    companion object {
        val empty = WeatherWindDomainModel(
            speed = 0.0,
            deg = 0.0,
            gust = 0.0
        )
    }
}