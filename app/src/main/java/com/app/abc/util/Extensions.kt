package com.app.abc.util

import android.view.View
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() { this.visibility = View.GONE }

fun String.convertDateOneFormatToAnother(inputPattern:String,outputPattern:String):String?{
    return try{// Define the input date format (UTC)
        val utcFormat = SimpleDateFormat(inputPattern, Locale.getDefault())
        utcFormat.timeZone = TimeZone.getTimeZone("UTC")

        // Parse the input UTC date-time string to Date
        val date = utcFormat.parse(this)

        // Define the output format (IST)
        val istFormat = SimpleDateFormat(outputPattern, Locale.getDefault())
        istFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata")

        // Format and return the date in IST
        if (date != null) {
            istFormat.format(date)
        }else null
    }catch (e:Exception){
        null
    }
}