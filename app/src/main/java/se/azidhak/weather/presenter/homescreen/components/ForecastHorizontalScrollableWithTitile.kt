package se.azidhak.weather.presenter.homescreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import se.azidhak.weather.domain.forecast.ForecastHourlyData

/**
 * A horizontal scrolling with showing title on top.
 * @param title A nullable string value which shown as title on top of list items.
 * @param items A list of [ForecastHourlyData] items.
 */
@Composable
fun ForecastHorizontalScrollableWithTitle(
    title: String? = null,
    items: List<ForecastHourlyData> = emptyList()
) {
    title?.let {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(start = 16.dp)
        ) {
            Text(
                text = it,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
    LazyRow {
        items(items = items) { item ->
            ForecastItem(
                time = item.time,
                temperature = item.temperature,
                description = item.forecastCondition?.description,
                iconRes = item.forecastCondition?.iconRes,
                humidity = item.humidity,
                windSpeed = item.windSpeed
            )
        }
    }
}