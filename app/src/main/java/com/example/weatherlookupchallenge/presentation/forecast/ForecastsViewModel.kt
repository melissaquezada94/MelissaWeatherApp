package com.example.weatherlookupchallenge.presentation.forecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weatherlookupchallenge.domain.models.Forecast
import com.hadilq.liveevent.LiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForecastsViewModel @Inject constructor() : ViewModel() {

    private val _forecastSelected = LiveEvent<Forecast>()
    val forecastSelected: LiveData<Forecast>
        get() = _forecastSelected

    fun onForecastSelected(forecast: Forecast) {
        _forecastSelected.postValue(forecast)
    }

}