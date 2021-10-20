package com.example.innopolisweatherfetcher.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherWindModel(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val deg: Double,
    @SerializedName("gust")
    val gust: Double
)