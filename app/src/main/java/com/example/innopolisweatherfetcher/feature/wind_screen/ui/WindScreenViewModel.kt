package com.example.innopolisweatherfetcher.feature.wind_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.WeatherInteractor
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherWindDomainModel
import kotlinx.coroutines.launch

class WindScreenViewModel(private val interactor: WeatherInteractor) : ViewModel() {
    val liveData: MutableLiveData<WeatherWindDomainModel> = MutableLiveData()

    fun requestWind() {
        viewModelScope.launch {
            liveData.postValue(interactor.getWeather().windDomainModel)
        }
    }
}