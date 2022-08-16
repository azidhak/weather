package se.azidhak.weather.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import se.azidhak.weather.data.repository.ForecastRepositoryImp
import se.azidhak.weather.domain.repository.ForecastRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindForeCastRepository(
        forecastRepositoryImp: ForecastRepositoryImp
    ): ForecastRepository
}