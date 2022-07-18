package com.example.weatherlookupchallenge.presentation.forecast


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherlookupchallenge.R
import com.example.weatherlookupchallenge.databinding.ItemForecastBinding
import com.example.weatherlookupchallenge.domain.models.Forecast
import com.squareup.picasso.Picasso

class ForecastsAdapter(
    private val onForecastClicked: (Forecast) -> Unit
) :
    ListAdapter<Forecast, ForecastsAdapter.ForecastsViewHolder>(DiffCallbackForecasts()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastsViewHolder {
        return ForecastsViewHolder(
            ItemForecastBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ForecastsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ForecastsViewHolder(private val itemBinding: ItemForecastBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(forecast: Forecast) {
            with(itemBinding) {
                tempTxt.text = itemBinding.root.context.getString(R.string.temp, forecast.temp)
                weatherTxt.text = forecast.weatherMain
                Picasso.with(itemBinding.root.context)
                    .load(
                        itemBinding.root.context.getString(
                            R.string.url_icon_weather,
                            forecast.icon
                        )
                    )
                    .into(iconWeather)
                itemForecast.setOnClickListener {
                    onForecastClicked(forecast)
                }
            }
        }
    }
}

class DiffCallbackForecasts : DiffUtil.ItemCallback<Forecast>() {

    override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem.dt == newItem.dt
    }

    override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem == newItem
    }
}