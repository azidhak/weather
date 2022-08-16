package se.azidhak.weather.domain.forecast

data class ForecastHourlyData(
    val time: String? = null,
    val temperature: String? = null,
    val humidity: String? = null,
    val windSpeed: String? = null,
    val forecastCondition: ForecastCondition? = null
)