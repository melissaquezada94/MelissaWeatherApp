package com.example.weatherlookupchallenge.data.remote

import com.example.weatherlookupchallenge.BuildConfig
import com.example.weatherlookupchallenge.data.remote.models.ForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("forecast")
    suspend fun fetchCityForecast(
        @Query("q") city: String,
        @Query("appid") appKey: String = BuildConfig.API_KEY,
        @Query("units") units: String = "imperial"
    ): Response<ForecastResponse>
}