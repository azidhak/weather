package se.azidhak.weather.style.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

private fun Colors.toggleColor(light: Color, dark: Color) = if (isLight) light else dark

val Colors.currentForecastBackground: Color
    get() = toggleColor(Gray1, Gray1.copy(alpha = 0.1f))
val Colors.currentForecastBorder: Color
    get() = toggleColor(Gray2, Gray2.copy(alpha = 0.1f))
val Colors.ForecastBackground: Color
    get() = toggleColor(Orange, BlueVeryDark)
val Colors.ForecastBorder: Color
    get() = toggleColor(Orange, BlueVeryDark)