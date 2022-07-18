package com.example.weatherlookupchallenge.data.remote


import com.example.weatherlookupchallenge.data.remote.models.ForecastResponse
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val api: WeatherAPI
) {

    suspend fun getCityForecast(city: String): ForecastResponse? {
        return try {
            val response = api.fetchCityForecast(city)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            //For simplicity we return null.
            //We can handle errors using sealed classes.
            null
        }
    }
}