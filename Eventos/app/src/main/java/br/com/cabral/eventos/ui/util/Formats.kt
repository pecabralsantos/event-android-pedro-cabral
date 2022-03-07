package br.com.cabral.eventos.ui.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Formats {

    private var locale = Locale("pt", "BR")
    private val formatDayMonthSimplified = SimpleDateFormat("EEE',' MMM dd '─' HH:mm", locale)
    private val formatDayMonthExtensive = SimpleDateFormat("EEEEE',' MMMMM dd \n HH:mm", locale)

    fun longToDateSimplified(time: Long?): String {
        val date = typeConversion(time)
        return formatDayMonthSimplified.format(date)
    }

    fun longToDateExtensive(time: Long?): String {
        val date = typeConversion(time)
        return formatDayMonthExtensive.format(date)
    }

    private fun typeConversion(time: Long?) = time?.let { Date(it) } ?: run { "" }

}