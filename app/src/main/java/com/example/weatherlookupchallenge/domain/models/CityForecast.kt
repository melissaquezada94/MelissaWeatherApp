package com.example.weatherlookupchallenge.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityForecast(
    val cityName: String? = "",
    val cityId: Int? = 0,
    val country: String? = "",
    val forecasts: List<Forecast>? = emptyList()
) : Parcelable
