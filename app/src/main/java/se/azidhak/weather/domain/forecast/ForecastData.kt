package se.azidhak.weather.domain.forecast

data class ForecastData(
    val date: String? = null,
    val country: Country? = null,
    val currentForecast: CurrentForecast? = null,
    val forecastHourly: List<ForecastHourlyData>? = null
)