package com.example.weatherlookupchallenge.data.remote.models


import com.google.gson.annotations.SerializedName


data class Clouds(
    @SerializedName("all")
    val all: Int
)