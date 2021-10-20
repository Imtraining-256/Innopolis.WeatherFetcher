package com.example.innopolisweatherfetcher.feature.weather_screen.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.innopolisweatherfetcher.R
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherDomainModel
import com.example.innopolisweatherfetcher.feature.wind_screen.ui.WindScreenActivity
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity : AppCompatActivity() {
    private val weatherViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weatherViewModel.liveData.observe(this, Observer(::render))

        weatherViewModel.requestWeather()

        val windButton = findViewById<Button>(R.id.windButton)
        windButton.setOnClickListener {
            Intent(this, WindScreenActivity::class.java).also { startActivity(it) }
        }
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