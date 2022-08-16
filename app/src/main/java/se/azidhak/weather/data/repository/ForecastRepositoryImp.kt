package se.azidhak.weather.data.repository

import se.azidhak.weather.data.mapper.toCurrentForecast
import se.azidhak.weather.data.mapper.toDate
import se.azidhak.weather.data.mapper.toForecastHourly
import se.azidhak.weather.data.remote.ForecastApi
import se.azidhak.weather.domain.forecast.Country
import se.azidhak.weather.domain.repository.ForecastRepository
import java.lang.Exception
import java.util.concurrent.CancellationException
import se.azidhak.weather.domain.network.Result
import se.azidhak.weather.domain.forecast.ForecastData
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class ForecastRepositoryImp @Inject constructor(
    private val forecastApi: ForecastApi
) : ForecastRepository {
    override suspend fun getForecast(country: Country): Result<ForecastData> {
        return try {
            val result = forecastApi.getForecast(
                lat = country.latitude,
                long = country.longitude,
                startDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE),
                endDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE)
            )
            if (result.isSuccessful && result.body() != null) {
                result.body().let {
                    Result.Success(
                        ForecastData(
                            date = it?.hourly?.time?.get(0)?.toDate(),
                            country = country,
                            currentForecast = it?.toCurrentForecast(),
                            forecastHourly = it?.toForecastHourly()
                        )
                    )
                }
            } else {
                Result.Failure()
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.Failure()
        }
    }
}