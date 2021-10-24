package com.example.innopolisweatherfetcher.feature.weather_screen.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.innopolisweatherfetcher.R
import com.example.innopolisweatherfetcher.feature.wind_screen.ui.WindScreenActivity
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity : AppCompatActivity() {
    private val weatherViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weatherViewModel.viewState.observe(this, ::render)

        val windButton = findViewById<Button>(R.id.windButton)
        windButton.setOnClickListener {
            Intent(this, WindScreenActivity::class.java).also { startActivity(it) }
        }
    }

    private fun render(state: ViewState) {
        findViewById<TextView>(R.id.tvTemperature).let {
            it.text = state.weatherDomainModel.temperature
        }

        findViewById<TextView>(R.id.tvHumidity).let {
            it.text = state.weatherDomainModel.humidity
        }
    }
}