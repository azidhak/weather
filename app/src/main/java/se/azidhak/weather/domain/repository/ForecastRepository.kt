package se.azidhak.weather.domain.repository

import se.azidhak.weather.domain.forecast.Country
import se.azidhak.weather.domain.network.Result
import se.azidhak.weather.domain.forecast.ForecastData

interface ForecastRepository {
    suspend fun getForecast(country: Country): Result<ForecastData>
}