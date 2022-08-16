package se.azidhak.weather.presenter.homescreen

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import se.azidhak.weather.domain.forecast.*
import se.azidhak.weather.style.theme.WeatherTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HomeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewState = viewModel.viewState.value

            WeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen(viewState = viewState)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getWeatherForecast()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    WeatherTheme {
        HomeScreen(
            viewState = ViewState(
                listOf(
                    ForecastData(
                        country = Country.STOCKHOLM,
                        currentForecast = CurrentForecast(
                            time = "12:00:00",
                            temperature = "12 C",
                            windSpeed = "12 km/h",
                            forecastCondition = ForecastCondition.ClearSky
                        ),
                        forecastHourly = listOf(
                            ForecastHourlyData(
                                time = "12:00:00",
                                temperature = "12 C",
                                windSpeed = "10 km/h",
                                humidity = "20 %",
                                forecastCondition = ForecastCondition.Foggy
                            ),
                            ForecastHourlyData(
                                time = "13:00:00",
                                temperature = "14 C",
                                windSpeed = "12 km/h",
                                humidity = "40 %",
                                forecastCondition = ForecastCondition.ClearSky
                            ),
                        )
                    )
                )
            )
        )
    }
}