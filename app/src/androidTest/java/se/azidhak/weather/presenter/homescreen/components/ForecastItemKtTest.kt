package se.azidhak.weather.presenter.homescreen.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import se.azidhak.weather.R
import se.azidhak.weather.style.theme.WeatherTheme

class ForecastItemKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        setContent()
    }

    @Test
    fun time_data_exist_and_shown_to_user() {
        composeTestRule.onNodeWithText("12:00:00").assertExists().assertIsDisplayed()
    }

    @Test
    fun temperature_data_exist_and_shown_to_user() {
        composeTestRule.onNodeWithText("13.5 C").assertExists().assertIsDisplayed()
    }

    @Test
    fun description_string_res_exist_and_text_shown_to_user() {
        composeTestRule.onNodeWithText("Foggy").assertExists().assertIsDisplayed()
    }

    @Test
    fun iconRes_drawable_res_exist_and_icon_shown_to_user() {
        composeTestRule.onNodeWithTag("iconRes").assertExists().assertIsDisplayed()
    }

    @Test
    fun humidity_data_exist_and_shown_to_user() {
        composeTestRule.onNodeWithText("10 %").assertExists().assertIsDisplayed()
    }

    @Test
    fun wind_speed_data_does_not_exist_and_shown_to_user() {
        composeTestRule.onNodeWithTag("windSpeed").assertDoesNotExist()
    }

    private fun setContent() {
       composeTestRule.setContent {
           WeatherTheme {
               ForecastItem(
                   time = "12:00:00",
                   temperature = "13.5 C",
                   description = R.string.foggy,
                   iconRes = R.drawable.ic_clouds_sun_sunny,
                   humidity = "10 %"
               )
           }
       }
    }
}