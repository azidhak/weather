package se.azidhak.weather.data.mapper

import java.text.SimpleDateFormat
import java.util.*

fun String?.epochToIso8601(): String? {
    return this?.let {
        val format = "yyyy-MM-dd HH:mm:ss"
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        sdf.format(Date(it.toLong() * 1000))
    }
}

fun String?.toDate(): String? {
    return this?.let {
        val format = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        sdf.format(Date(it.toLong() * 1000))
    }
}

fun String?.toTime(): String? {
    return this?.let {
        val format = "HH:mm:ss"
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        sdf.format(Date(it.toLong() * 1000))
    }
}