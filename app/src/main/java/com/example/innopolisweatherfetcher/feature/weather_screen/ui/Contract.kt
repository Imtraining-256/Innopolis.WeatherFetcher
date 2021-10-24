package com.example.innopolisweatherfetcher.feature.weather_screen.ui

import com.example.innopolisweatherfetcher.base.Event
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherDomainModel

data class ViewState(
    val weatherDomainModel: WeatherDomainModel,
    val errorMessage: String?,
    val isLoading: Boolean
)

sealed class UIEvent : Event {
    object RequestWind : UIEvent()
}

sealed class DataEvent : Event {
    object OnLoadData : DataEvent()
    data class SuccessNewsRequest(val weatherDomainModel: WeatherDomainModel) : DataEvent()
    data class ErrorNewsRequest(val errorMessage: String) : DataEvent()
}