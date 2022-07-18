package com.example.weatherlookupchallenge.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherlookupchallenge.R
import com.example.weatherlookupchallenge.domain.RepositoryForecast
import com.example.weatherlookupchallenge.domain.models.CityForecast
import com.hadilq.liveevent.LiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchCityViewModel @Inject constructor(
    private val repository: RepositoryForecast
) : ViewModel() {

    private val _cityForecast = LiveEvent<CityForecast>()
    val cityForecast: LiveData<CityForecast>
        get() = _cityForecast

    private val _errorMessage = LiveEvent<Int>()
    val errorMessage: LiveData<Int>
        get() = _errorMessage

    fun onSearchCity(cityName: String) {
        if (cityName.isNotEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                val cityForecast = repository.getCityForecast(cityName)
                if (cityForecast != null) {
                    cityForecast.let {
                        _cityForecast.postValue(it)
                    }
                } else {
                    _errorMessage.postValue(R.string.city_not_found)
                }
            }
        } else {
            _errorMessage.postValue(R.string.blank_city_message)
        }
    }

}