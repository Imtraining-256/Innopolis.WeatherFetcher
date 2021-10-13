package com.example.innopolisweatherfetcher.feature.weather_screen.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.innopolisweatherfetcher.R
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherDomainModel
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity : AppCompatActivity() {
    val weatherViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weatherViewModel.liveData.observe(this, Observer(::render))

        weatherViewModel.requestWeather()
    }

    private fun render(state: WeatherDomainModel) {
        findViewById<TextView>(R.id.tvTemperature).let {
            it.text = state.temperature
        }

        findViewById<TextView>(R.id.tvHumidity).let {
            it.text = state.humidity
        }
    }
}