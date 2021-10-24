package com.example.innopolisweatherfetcher.feature.weather_screen.ui

import com.example.innopolisweatherfetcher.base.BaseViewModel
import com.example.innopolisweatherfetcher.base.Event
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.WeatherInteractor
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {
    init {
        processUiEvent(UIEvent.RequestWind)
    }

    override fun initialViewState(): ViewState {
        return ViewState(WeatherDomainModel.empty, errorMessage = null, isLoading = true)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.RequestWind -> {
                processDataEvent(DataEvent.OnLoadData)
                interactor.getWeather().fold(
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessNewsRequest(it))
                    },
                    onError = {
                        processDataEvent(DataEvent.ErrorNewsRequest(it.localizedMessage ?: ""))
                    }
                )
            }
            is DataEvent.OnLoadData -> {
                return previousState.copy(isLoading = true)
            }

            is DataEvent.SuccessNewsRequest -> {
                return previousState.copy(
                    weatherDomainModel = event.weatherDomainModel,
                    isLoading = false
                )
            }

            is DataEvent.ErrorNewsRequest -> {
            }
        }

        return null
    }
}