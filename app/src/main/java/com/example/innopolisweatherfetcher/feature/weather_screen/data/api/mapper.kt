package com.example.innopolisweatherfetcher.feature.weather_screen.data.api

import com.example.innopolisweatherfetcher.feature.weather_screen.data.model.WeatherModel
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherDomainModel

fun WeatherModel.toDomain(): WeatherDomainModel {
    return WeatherDomainModel(
        this.main.temp
    )
}