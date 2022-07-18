package com.example.weatherlookupchallenge.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.weatherlookupchallenge.R
import com.example.weatherlookupchallenge.databinding.FragmentSearchCityBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchCityFragment : Fragment() {

    private lateinit var binding: FragmentSearchCityBinding
    private val viewModel: SearchCityViewModel by viewModels<SearchCityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchCityBinding.inflate(inflater, container, false)

        viewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            Snackbar.make(binding.snackBarAnchor, errorMessage, Snackbar.LENGTH_SHORT).show()
        }

        viewModel.cityForecast.observe(viewLifecycleOwner) { cityForecast ->
            findNavController().navigate(
                SearchCityFragmentDirections.actionSearchCityFragmentToCityWeatherListFragment(
                    cityForecast
                )
            )
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            activity?.title = getString(R.string.weather)
            lookupBtn.setOnClickListener {
                viewModel.onSearchCity(cityNameTxt.text.toString())
            }
        }
    }

}