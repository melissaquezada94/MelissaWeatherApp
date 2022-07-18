package com.example.weatherlookupchallenge.data.remote.models


import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<ForecastItemList>,
    @SerializedName("message")
    val message: Int
)