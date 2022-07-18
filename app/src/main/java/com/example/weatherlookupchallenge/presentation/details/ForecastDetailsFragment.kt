package com.example.weatherlookupchallenge.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.weatherlookupchallenge.R
import com.example.weatherlookupchallenge.databinding.FragmentForecastDetailsBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastDetailsFragment : Fragment() {

    private lateinit var binding: FragmentForecastDetailsBinding
    private val args by navArgs<ForecastDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForecastDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = args.cityName
        with(binding) {
            temperatureTxt.text = getString(R.string.temp_details, args.forecast.temp)
            feelsLikeTxt.text = getString(R.string.feels_like, args.forecast.feelsLike)
            weatherDescriptionTxt.text = args.forecast.weatherDescription
            weatherMainTxt.text = args.forecast.weatherMain
            Picasso.with(context)
                .load(getString(R.string.url_icon_weather_2x, args.forecast.icon))
                .into(iconWeatherImage)
        }
    }

}