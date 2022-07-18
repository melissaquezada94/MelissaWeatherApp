package com.example.weatherlookupchallenge.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Forecast(
    val dt: Int = 0,
    val weatherMain: String? = "",
    val weatherDescription: String? = "",
    val feelsLike: Double? = 0.0,
    val temp: Double? = 0.0,
    val tempMax: Double? = 0.0,
    val tempMin: Double? = 0.0,
    val icon: String? = ""
) : Parcelable
