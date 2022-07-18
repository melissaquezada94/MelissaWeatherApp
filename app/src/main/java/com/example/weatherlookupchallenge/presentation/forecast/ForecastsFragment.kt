package com.example.weatherlookupchallenge.presentation.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.weatherlookupchallenge.databinding.FragmentForecastsBinding
import com.example.weatherlookupchallenge.domain.models.Forecast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastsFragment : Fragment() {

    private lateinit var binding: FragmentForecastsBinding
    private val args by navArgs<ForecastsFragmentArgs>()
    private val viewModel: ForecastsViewModel by viewModels<ForecastsViewModel>()
    private val adapter by lazy { ForecastsAdapter(::onClickForecast) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForecastsBinding.inflate(inflater, container, false)

        viewModel.forecastSelected.observe(viewLifecycleOwner) { forecast ->
            findNavController().navigate(
                ForecastsFragmentDirections.actionCityWeatherListFragmentToWeatherDetailsFragment(
                    forecast,
                    args.cityForecast.cityName ?: ""
                )
            )
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = args.cityForecast.cityName
        with(binding) {
            forecastRecyclerView.adapter = adapter
            adapter.submitList(args.cityForecast.forecasts)
        }

    }

    private fun onClickForecast(forecast: Forecast) {
        viewModel.onForecastSelected(forecast)
    }

}