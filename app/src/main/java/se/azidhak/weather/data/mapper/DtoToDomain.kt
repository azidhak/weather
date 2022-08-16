package se.azidhak.weather.data.mapper

import se.azidhak.weather.data.remote.ForecastResponse
import se.azidhak.weather.domain.forecast.CurrentForecast
import se.azidhak.weather.domain.forecast.ForecastCondition.Companion.getWeatherCondition
import se.azidhak.weather.domain.forecast.ForecastHourlyData

fun ForecastResponse?.toCurrentForecast(): CurrentForecast? {
    return this?.let {
        CurrentForecast(
            time = it.currentWeather.time.epochToIso8601(),
            temperature = "${it.currentWeather.temperature} ${it.hourlyUnits.temperature2m}",
            windSpeed = "${it.currentWeather.windSpeed} ${it.hourlyUnits.windSpeeds}",
            forecastCondition = getWeatherCondition(it.currentWeather.weatherCode)
        )
    }
}

fun ForecastResponse?.toForecastHourly(): List<ForecastHourlyData>? {
    return this?.let {
        it.hourly.time.mapIndexed { index, time ->
            ForecastHourlyData(
                time = time.toTime(),
                temperature = "${it.hourly.temperature2m[index]} ${it.hourlyUnits.temperature2m}",
                windSpeed = "${it.hourly.windSpeeds[index]} ${it.hourlyUnits.windSpeeds}",
                humidity = "${it.hourly.humidities[index]} ${it.hourlyUnits.humidities}",
                forecastCondition = getWeatherCondition(it.hourly.weatherCodes[index])
            )
        }
    }
}