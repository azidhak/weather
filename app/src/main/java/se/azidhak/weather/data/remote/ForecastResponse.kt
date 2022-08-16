package se.azidhak.weather.data.remote

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ForecastResponse(
    @field:Json(name = "current_weather")
    val currentWeather: CurrentWeather,
    @field:Json(name = "elevation")
    val elevation: Double,
    @field:Json(name = "generationtime_ms")
    val generationTimeMs: Double,
    @field:Json(name = "hourly")
    val hourly: Hourly,
    @field:Json(name = "hourly_units")
    val hourlyUnits: HourlyUnits,
    @field:Json(name = "latitude")
    val latitude: Double,
    @field:Json(name = "longitude")
    val longitude: Double,
    @field:Json(name = "utc_offset_seconds")
    val utcOffsetSeconds: Int
)

@Keep
data class CurrentWeather(
    @field:Json(name = "time")
    val time: String?,
    @field:Json(name = "temperature")
    val temperature: Double,
    @field:Json(name = "weathercode")
    val weatherCode: Int,
    @field:Json(name = "windspeed")
    val windSpeed: Double
)

@Keep
data class Hourly(
    @field:Json(name = "time")
    val time: List<String>,
    @field:Json(name = "temperature_2m")
    val temperature2m: List<Double>,
    @field:Json(name = "weathercode")
    val weatherCodes: List<Int>,
    @field:Json(name = "relativehumidity_2m")
    val humidities: List<Double>,
    @field:Json(name = "windspeed_10m")
    val windSpeeds: List<Double>
)

@Keep
data class HourlyUnits(
    @field:Json(name = "time")
    val time: String,
    @field:Json(name = "temperature_2m")
    val temperature2m: String,
    @field:Json(name = "weathercode")
    val weatherCodes: String,
    @field:Json(name = "relativehumidity_2m")
    val humidities: String,
    @field:Json(name = "windspeed_10m")
    val windSpeeds: String
)