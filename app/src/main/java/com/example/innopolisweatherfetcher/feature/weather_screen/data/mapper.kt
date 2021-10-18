package com.example.innopolisweatherfetcher.feature.weather_screen.data

import com.example.innopolisweatherfetcher.feature.weather_screen.data.model.WeatherModel
import com.example.innopolisweatherfetcher.feature.weather_screen.data.model.WeatherWindModel
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherDomainModel
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherWindDomainModel

fun WeatherModel.toDomain() = WeatherDomainModel(
    temperature = main.temp,
    humidity = this.main.humidity,
    windDomainModel = wind.toDomain()
)

fun WeatherWindModel.toDomain() = WeatherWindDomainModel(
    speed = speed,
    deg = deg,
    gust = gust
)


