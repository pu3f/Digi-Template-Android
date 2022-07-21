package com.digimaster.digicore.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class DigiTimeUtils {
    companion object{
        fun covertTimeToText(dataDate: String?): String? {
            var convTime: String? = null
            val prefix = ""
            val suffix = "Ago"
            try {
                val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("id", "ID"))
                val hourFormat = SimpleDateFormat("HH:mm", Locale("id", "ID"))
                val dayFormat = SimpleDateFormat("EE", Locale("id", "ID"))
                val newDateFormat = SimpleDateFormat("dd MMM", Locale("id", "ID"))

                val pasTime: Date = dateFormat.parse(dataDate)
                val nowTime = Date()
                val dateDiff: Long = nowTime.getTime() - pasTime.getTime()
                val second: Long = TimeUnit.MILLISECONDS.toSeconds(dateDiff)
                val minute: Long = TimeUnit.MILLISECONDS.toMinutes(dateDiff)
                val hour: Long = TimeUnit.MILLISECONDS.toHours(dateDiff)
                val day: Long = TimeUnit.MILLISECONDS.toDays(dateDiff)
                if (second < 60) {
//                    convTime = "$second Seconds $suffix"
                    convTime = "Baru"
                }
//                else if (minute < 60) {
//                    convTime = "$minute Minutes $suffix"
//                }
                else if (hour < 24) {
//                    convTime = "$hour Hours $suffix"
                    convTime = hourFormat.format(pasTime)
                } else if (day >= 7) {
//                    convTime = if (day > 360) {
//                        (day / 360).toString() + " Years " + suffix
//                    } else if (day > 30) {
//                        (day / 30).toString() + " Months " + suffix
//                    } else {
//                        (day / 7).toString() + " Week " + suffix
//                    }
                    convTime = newDateFormat.format(pasTime)
                } else if (day < 7) {
//                    convTime = "$day Days $suffix"
                    convTime = dayFormat.format(pasTime)
                }
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return convTime
        }
    }
}