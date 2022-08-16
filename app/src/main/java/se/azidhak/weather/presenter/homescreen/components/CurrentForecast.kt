package se.azidhak.weather.presenter.homescreen.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import se.azidhak.weather.R
import se.azidhak.weather.style.theme.WeatherTheme
import se.azidhak.weather.style.theme.currentForecastBackground
import se.azidhak.weather.style.theme.currentForecastBorder

/**
 * An item showing current forecast information.
 * @param time A nullable string value which shown as time.
 * @param temperature A nullable string value which shown as temperature.
 * @param description A nullable stringRes value which contain description value.
 * @param iconRes A nullable drawableRes value which contain icon value.
 * @param windSpeed A nullable string value which shown as wind speed.
 */
@Composable
fun CurrentForecastCard(
    time: String? = null,
    temperature: String? = null,
    @StringRes description: Int? = null,
    @DrawableRes iconRes: Int? = null,
    windSpeed: String? = null
) {
    Surface(
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(1.dp, MaterialTheme.colors.currentForecastBorder),
        modifier = Modifier.padding(16.dp),
        color = MaterialTheme.colors.currentForecastBackground
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.current),
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onBackground
                )
                time?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    temperature?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.ExtraBold),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 16.dp),
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                    description?.let {
                        Text(
                            text = stringResource(id = it),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 16.dp),
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    iconRes?.let {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
            }

            windSpeed?.let {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.wind_speed),
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.onBackground
                    )
                    Text(
                        text = it,
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CurrentForecastCardPreview(
) {
    WeatherTheme {
        CurrentForecastCard(
            time = "12:00:00",
            temperature = "13.5 C",
            description = R.string.foggy,
            iconRes = R.drawable.ic_clouds_sun_sunny,
            windSpeed = "11 Km/h"
        )
    }

}
