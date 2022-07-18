package com.example.weatherlookupchallenge.data.mappers

import com.example.weatherlookupchallenge.data.remote.models.ForecastItemList
import com.example.weatherlookupchallenge.data.remote.models.ForecastResponse
import com.example.weatherlookupchallenge.domain.models.CityForecast
import com.example.weatherlookupchallenge.domain.models.Forecast


fun ForecastItemList.toDomain(): Forecast = Forecast(
    dt = dt,
    weatherMain = weather?.firstOrNull()?.main,
    weatherDescription = weather?.firstOrNull()?.description,
    feelsLike = main?.feelsLike,
    temp = main?.temp,
    tempMax = main?.tempMax,
    tempMin = main?.tempMin,
    icon = weather?.firstOrNull()?.icon
)

fun ForecastResponse.toDomain(): CityForecast = CityForecast(
    cityName = city.name,
    cityId = city.id,
    country = city.country,
    forecasts = list.map { it.toDomain() }
)