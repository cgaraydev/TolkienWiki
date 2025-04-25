package com.cgaraydev.tolkienapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toTimeString(): String {
    val minutes = (this / 60).toInt()
    val seconds = (this % 60).toInt()
    return "%02d:%02d".format(minutes, seconds)
}

fun Long.toDateString(): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return sdf.format(Date(this))
}


//fun Long.toTimeString(): String {
//    val minutes = this / 60
//    val seconds = this % 60
//    return buildString {
//        append(minutes.toString().padStart(2, '0'))
//        append(":")
//        append(seconds.toString().padStart(2, '0'))
//    }
//}

//fun Long.toDateString(): String {
//    val formatter = DateTimeFormatter
//        .ofPattern("dd/MM/yyyy")
//        .withLocale(Locale.getDefault()) // <- Fix explícito para locale
//    return Instant.ofEpochMilli(this)
//        .atZone(ZoneId.systemDefault())
//        .format(formatter)
//}

