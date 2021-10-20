package com.example.innopolisweatherfetcher.feature.weather_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.WeatherInteractor
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherDomainModel
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val interactor: WeatherInteractor) : ViewModel() {
    val liveData: MutableLiveData<WeatherDomainModel> = MutableLiveData()

    fun requestWeather() {
        viewModelScope.launch {
            liveData.postValue(interactor.getWeather())
        }
    }
}