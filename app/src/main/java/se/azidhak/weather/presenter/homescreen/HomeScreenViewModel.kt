package se.azidhak.weather.presenter.homescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import se.azidhak.weather.domain.forecast.Country
import se.azidhak.weather.domain.forecast.ForecastData
import se.azidhak.weather.domain.network.Result
import se.azidhak.weather.domain.repository.ForecastRepository
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: ForecastRepository
) : ViewModel() {

    val viewState: MutableState<ViewState> = mutableStateOf(ViewState())

    fun getWeatherForecast() {
        val viewDataList: MutableList<ForecastData> = mutableListOf()
        viewModelScope.launch {
            val forecasts = Country.values().map { city ->
                async { repository.getForecast(city) }
            }.awaitAll()
                .filterNot { it is Result.Failure }

            forecasts.forEach { result ->
                when (result) {
                    is Result.Success -> {
                        result.data?.let {
                            viewDataList.add(it)
                        }
                    }
                    is Result.Failure -> Unit
                }
            }
            viewState.value = ViewState(forecastData = viewDataList)
        }
    }
}