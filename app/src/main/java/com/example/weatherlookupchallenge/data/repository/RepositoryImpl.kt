package com.example.weatherlookupchallenge.data.repository

import com.example.weatherlookupchallenge.data.mappers.toDomain
import com.example.weatherlookupchallenge.data.remote.NetworkDataSource
import com.example.weatherlookupchallenge.domain.RepositoryForecast
import com.example.weatherlookupchallenge.domain.models.CityForecast
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource
) : RepositoryForecast {

    override suspend fun getCityForecast(cityName: String): CityForecast? {
        val response = networkDataSource.getCityForecast(cityName)
        return response?.toDomain()
    }
}