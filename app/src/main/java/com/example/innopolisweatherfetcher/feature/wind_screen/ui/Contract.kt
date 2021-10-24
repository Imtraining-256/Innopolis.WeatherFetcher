package com.example.innopolisweatherfetcher.feature.wind_screen.ui

import com.example.innopolisweatherfetcher.base.Event
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherWindDomainModel

data class ViewState(
    val weatherWindDomainModel: WeatherWindDomainModel,
    val errorMessage: String?,
    val isLoading: Boolean
)

sealed class UIEvent : Event {
    object RequestWind : UIEvent()
}

sealed class DataEvent : Event {
    object OnLoadData : DataEvent()
    data class SuccessNewsRequest(val weatherWindDomainModel: WeatherWindDomainModel) : DataEvent()
    data class ErrorNewsRequest(val errorMessage: String) : DataEvent()
}