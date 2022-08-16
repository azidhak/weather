package se.azidhak.weather.presenter.homescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import se.azidhak.weather.R
import se.azidhak.weather.presenter.homescreen.components.CurrentForecastCard
import se.azidhak.weather.presenter.homescreen.components.ForecastHorizontalScrollableWithTitle
import se.azidhak.weather.style.theme.ForecastBackground
import se.azidhak.weather.style.theme.ForecastBorder

@Composable
fun HomeScreen(
    viewState: ViewState
) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(items = viewState.forecastData) { item ->
                Surface(
                    shape = MaterialTheme.shapes.large,
                    border = BorderStroke(1.dp, MaterialTheme.colors.ForecastBorder),
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colors.ForecastBackground
                ) {
                    Column {
                        item.country?.name?.let {
                            Text(
                                modifier = Modifier.padding(top = 24.dp, start = 16.dp),
                                text = it.lowercase().replace("_"," ").replaceFirstChar { firstChar -> firstChar.uppercase() },
                                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colors.onBackground
                            )
                        }

                        item.currentForecast?.let {
                            CurrentForecastCard(
                                time = it.time,
                                temperature = it.temperature,
                                description = it.forecastCondition?.description,
                                iconRes = it.forecastCondition?.iconRes,
                                windSpeed = it.windSpeed,
                            )
                        }

                        item.forecastHourly?.let {
                            ForecastHorizontalScrollableWithTitle(
                                title = stringResource(R.string.tomorrow),
                                items = item.forecastHourly,
                            )
                        }
                    }
                }
            }
        }
    }
}