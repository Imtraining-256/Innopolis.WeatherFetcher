package com.example.innopolisweatherfetcher.feature.weather_screen.ui

import androidx.appcompat.app.AppCompatActivity
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity : AppCompatActivity() {
    val weatherViewModel by viewModel<WeatherScreenViewModel>()
}