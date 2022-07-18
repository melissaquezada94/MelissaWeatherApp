package com.example.weatherlookupchallenge.data.remote.models


import com.google.gson.annotations.SerializedName


data class Sys(
    @SerializedName("pod")
    val pod: String
)