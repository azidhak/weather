package se.azidhak.weather.domain.forecast

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import se.azidhak.weather.R

sealed class ForecastCondition(
    @StringRes val description: Int,
    @DrawableRes val iconRes: Int? = null
) {
    object ClearSky : ForecastCondition(
        description = R.string.clear_sky,
        iconRes = R.drawable.ic_sun_sunny_temperature
    )

    object MainlyClear : ForecastCondition(
        description = R.string.mainly_clear,
        iconRes = R.drawable.ic_clouds_sun_sunny
    )

    object PartlyCloudy : ForecastCondition(
        description = R.string.partly_cloudy,
        iconRes = R.drawable.ic_clouds_sun_sunny
    )

    object Overcast : ForecastCondition(
        description = R.string.overcast,
        iconRes = R.drawable.ic_clouds_storm_sunny
    )

    object Foggy : ForecastCondition(
        description = R.string.foggy,
        iconRes = R.drawable.ic_fog_foggy_moon_night
    )

    object DepositingRimeFog : ForecastCondition(
        description = R.string.depositing_rime_fog,
        iconRes = R.drawable.ic_fog_foggy_moon_night
    )

    object LightDrizzle : ForecastCondition(
        description = R.string.light_drizzle,
        iconRes = R.drawable.ic_cloud_drizzel_rain
    )

    object ModerateDrizzle : ForecastCondition(
        description = R.string.moderate_drizzle,
        iconRes = R.drawable.ic_cloud_drizzel_rain
    )

    object DenseDrizzle : ForecastCondition(
        description = R.string.dense_drizzle,
        iconRes = R.drawable.ic_cloud_drizzel_rain
    )

    object LightFreezingDrizzle : ForecastCondition(
        description = R.string.slight_freezing_drizzle,
        iconRes = R.drawable.ic_cloud_drizzel_rain
    )

    object DenseFreezingDrizzle : ForecastCondition(
        description = R.string.dense_freezing_drizzle,
        iconRes = R.drawable.ic_cloud_drizzel_rain
    )

    object SlightRain : ForecastCondition(
        description = R.string.slight_rain,
        iconRes = R.drawable.ic_clouds_cloudy_forecast_rain
    )

    object ModerateRain : ForecastCondition(
        description = R.string.rainy,
        iconRes = R.drawable.ic_clouds_cloudy_forecast_rain
    )

    object HeavyRain : ForecastCondition(
        description = R.string.heavy_rain,
        iconRes = R.drawable.ic_clouds_cloudy_forecast_rain
    )

    object HeavyFreezingRain : ForecastCondition(
        description = R.string.heavy_freezing_rain,
        iconRes = R.drawable.ic_clouds_cloudy_forecast_rain
    )

    object SlightSnowFall : ForecastCondition(
        description = R.string.slight_snow_fall,
        iconRes = R.drawable.ic_clouds_snow_winter
    )

    object ModerateSnowFall : ForecastCondition(
        description = R.string.moderate_snow_fall,
        iconRes = R.drawable.ic_clouds_snow_winter
    )

    object HeavySnowFall : ForecastCondition(
        description = R.string.heavy_snow_fall,
        iconRes = R.drawable.ic_clouds_snow_winter
    )

    object SnowGrains : ForecastCondition(
        description = R.string.snow_grains,
        iconRes = R.drawable.ic_clouds_snow_winter
    )

    object SlightRainShowers : ForecastCondition(
        description = R.string.slight_rain_showers,
        iconRes = R.drawable.ic_clouds_cloudy_forecast_rain
    )

    object ModerateRainShowers : ForecastCondition(
        description = R.string.moderate_rain_showers,
        iconRes = R.drawable.ic_clouds_cloudy_forecast_rain
    )

    object ViolentRainShowers : ForecastCondition(
        description = R.string.violent_rain_showers,
        iconRes = R.drawable.ic_clouds_cloudy_forecast_rain
    )

    object SlightSnowShowers : ForecastCondition(
        description = R.string.light_snow_showers,
        iconRes = R.drawable.ic_christmas_snow_snowflake_winter
    )

    object HeavySnowShowers : ForecastCondition(
        description = R.string.heavy_snow_showers,
        iconRes = R.drawable.ic_christmas_snow_snowflake_winter
    )

    object ModerateThunderstorm : ForecastCondition(
        description = R.string.moderate_thunderstorm,
        iconRes = R.drawable.ic_clouds_rain_storm_thunder
    )

    object SlightHailThunderstorm : ForecastCondition(
        description = R.string.thunderstorm_with_slight_hail,
        iconRes = R.drawable.ic_clouds_rain_storm_thunder
    )

    object HeavyHailThunderstorm : ForecastCondition(
        description = R.string.thunderstorm_with_heavy_hail,
        iconRes = R.drawable.ic_clouds_rain_storm_thunder
    )

    companion object {
        fun getWeatherCondition(code: Int): ForecastCondition {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}