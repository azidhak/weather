package se.azidhak.weather.domain.network

sealed class Result<T> {
    class Success<T>(val data: T?): Result<T>()
    class Failure<T>(val message: String? = null): Result<T>()
}