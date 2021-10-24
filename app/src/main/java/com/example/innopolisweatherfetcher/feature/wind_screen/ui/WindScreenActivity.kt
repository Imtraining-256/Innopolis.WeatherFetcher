package com.example.innopolisweatherfetcher.feature.wind_screen.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.innopolisweatherfetcher.R
import org.koin.android.viewmodel.ext.android.viewModel

class WindScreenActivity : AppCompatActivity() {
    private val windScreenViewModel by viewModel<WindScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)

        windScreenViewModel.viewState.observe(this, ::render)
    }

    private fun render(state: ViewState) {
        findViewById<TextView>(R.id.tvWind).let {
            it.text = state.weatherWindDomainModel.speed.toString()
        }
    }
}