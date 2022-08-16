package se.azidhak.weather.domain.forecast

data class CurrentForecast(
    val time: String? = null,
    val temperature: String? = null,
    val forecastCondition: ForecastCondition? = null,
    val windSpeed: String? = null
)