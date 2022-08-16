package se.azidhak.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import se.azidhak.weather.data.remote.ForecastApi
import javax.inject.Singleton

private const val BASE_URL = "https://api.open-meteo.com/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideForecastApi(): ForecastApi {
        return Retrofit
            .Builder()
            .baseUrl("$BASE_URL")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
}