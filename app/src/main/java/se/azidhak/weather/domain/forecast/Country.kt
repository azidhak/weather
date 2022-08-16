package se.azidhak.weather.domain.forecast

enum class Country(
    val latitude: Double,
    val longitude: Double
    ) {
    STOCKHOLM(59.3328, 18.0645),
    GOTHENBURG(57.6999561, 11.9607372),
    MOUNTAIN_VIEW(37.4134508,-122.1513073),
    LONDON(51.5287352,-0.3817815),
    NEW_YORK(40.6976701,-74.2598705),
    BERLIN(52.5235, 13.4115),
    MALMO(55.5702828, 12.8758894)
}