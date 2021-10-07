package com.example.innopolisweatherfetcher.feature.weather_screen.data.api

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/weather")
    fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") appId: String = "key"
    ): ResponseBody
}