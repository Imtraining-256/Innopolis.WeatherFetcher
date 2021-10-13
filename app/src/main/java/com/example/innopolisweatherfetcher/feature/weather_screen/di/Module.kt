package com.example.innopolisweatherfetcher.feature.weather_screen.di

import com.example.innopolisweatherfetcher.feature.weather_screen.data.api.WeatherApi
import com.example.innopolisweatherfetcher.feature.weather_screen.data.api.WeatherRemoteSource
import com.example.innopolisweatherfetcher.feature.weather_screen.data.api.WeatherRepository
import com.example.innopolisweatherfetcher.feature.weather_screen.data.api.WeatherRepositoryImpl
import com.example.innopolisweatherfetcher.feature.weather_screen.domain.WeatherInteractor
import com.example.innopolisweatherfetcher.feature.weather_screen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.openweathermap.org/"

val appModule = module {
    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java)
    }

    single<WeatherRemoteSource> {
        WeatherRemoteSource(get<WeatherApi>())
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(get<WeatherRemoteSource>())
    }

    single<WeatherInteractor> {
        WeatherInteractor(get<WeatherRepository>())
    }

    viewModel {
        WeatherScreenViewModel(get<WeatherInteractor>())
    }
}