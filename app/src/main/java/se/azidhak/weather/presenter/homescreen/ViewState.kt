package se.azidhak.weather.presenter.homescreen

import se.azidhak.weather.domain.forecast.ForecastData

data class ViewState(
    val forecastData: List<ForecastData> = emptyList()
)