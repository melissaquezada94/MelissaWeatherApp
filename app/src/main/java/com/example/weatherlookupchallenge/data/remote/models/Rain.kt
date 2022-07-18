package com.example.weatherlookupchallenge.data.remote.models


import com.google.gson.annotations.SerializedName


data class Rain(
    @SerializedName("3h")
    val h: Double
)