package se.azidhak.weather.presenter.homescreen

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import se.azidhak.weather.domain.forecast.*
import se.azidhak.weather.domain.network.Result
import se.azidhak.weather.domain.repository.ForecastRepository
import se.azidhak.weather.utils.MainCoroutineRule

@OptIn(ExperimentalCoroutinesApi::class)
class HomeScreenViewModelTest {

    private lateinit var viewModel: HomeScreenViewModel

    @Mock
    private lateinit var repository: ForecastRepository

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        runTest {
            whenever(repository.getForecast(any())).thenReturn(
                Result.Success(
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
        }

        viewModel = HomeScreenViewModel(repository)
    }

    @Test
    fun getWeatherForecastCalled_returnWithSuccessResult() = runTest(mainCoroutineRule.dispatcher) {
        viewModel.getWeatherForecast()
        advanceUntilIdle()
        Assert.assertEquals(
            ViewState(
                List(7) {
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
                }
            ),
            viewModel.viewState.value)
    }
}