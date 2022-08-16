package se.azidhak.weather.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {
    @GET("v1/forecast?timeformat=unixtime&current_weather=true&timezone=CET&hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m")
    suspend fun getForecast(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
    ): Response<ForecastResponse>
}