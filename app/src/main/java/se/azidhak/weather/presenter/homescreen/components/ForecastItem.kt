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
import androidx.compose.ui.platform.testTag
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
 * An item showing hourly forecast information.
 * @param time A nullable string value which shown as time.
 * @param temperature A nullable string value which shown as temperature.
 * @param description A nullable stringRes value which contain description value.
 * @param iconRes A nullable drawableRes value which contain icon value.
 * @param windSpeed A nullable string value which shown as wind speed.
 * @param humidity A nullable string value which shown as humidity.
 */
@Composable
fun ForecastItem(
    time: String? = null,
    temperature: String? = null,
    @StringRes description: Int? = null,
    @DrawableRes iconRes: Int? = null,
    humidity: String? = null,
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
            time?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground
                )
            }

            iconRes?.let {
                Icon(
                    modifier = Modifier.testTag("iconRes"),
                    painter = painterResource(id = it),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }

            temperature?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.ExtraBold),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp),
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

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                windSpeed?.let {
                    Row(
                        modifier = Modifier.testTag("windSpeed"),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_breeze_fast_speed_weather_wind),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colors.onBackground
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = it,
                            style = MaterialTheme.typography.subtitle2,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                humidity?.let {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_humidity_alt),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colors.onBackground
                        )
                        Spacer(modifier = Modifier.width(8.dp))
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
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ForecastItemPreview(
) {
    WeatherTheme {
        ForecastItem(
            time = "12:00:00",
            temperature = "13.5 C",
            description = R.string.foggy,
            iconRes = R.drawable.ic_clouds_sun_sunny,
            humidity = "10 %",
            windSpeed = "11 Km/h"
        )
    }

}
