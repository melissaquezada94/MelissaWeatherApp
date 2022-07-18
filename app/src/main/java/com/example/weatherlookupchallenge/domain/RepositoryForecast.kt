package com.example.weatherlookupchallenge.domain

import com.example.weatherlookupchallenge.domain.models.CityForecast

interface RepositoryForecast {
    /**
     * Get a list of forecasts by a city name.
     * If city is not found, this method returns null.
     */
    suspend fun getCityForecast(cityName: String): CityForecast?
}