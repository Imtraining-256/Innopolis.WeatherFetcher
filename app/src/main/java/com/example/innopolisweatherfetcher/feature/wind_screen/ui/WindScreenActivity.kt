package com.example.innopolisweatherfetcher.feature.wind_screen.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.innopolisweatherfetcher.R
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.model.WeatherWindDomainModel
import org.koin.android.viewmodel.ext.android.viewModel

class WindScreenActivity : AppCompatActivity() {
    private val windScreenViewModel by viewModel<WindScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)

        windScreenViewModel.liveData.observe(this, Observer(::render))

        windScreenViewModel.requestWind()
    }

    private fun render(state: WeatherWindDomainModel) {
        findViewById<TextView>(R.id.tvWind).let { it.text = state.speed.toString() }
    }
}