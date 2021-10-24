package com.example.innopolisweatherfetcher.feature.weather_screen.domain.model

class WeatherDomainModel(
    val temperature: String,
    val humidity: String,
    val windDomainModel: WeatherWindDomainModel
) {
    companion object {
        val empty = WeatherDomainModel(
            temperature = "",
            humidity = "",
            windDomainModel = WeatherWindDomainModel.empty
        )
    }
}