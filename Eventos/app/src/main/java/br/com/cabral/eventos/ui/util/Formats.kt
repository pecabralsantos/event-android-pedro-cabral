package br.com.cabral.eventos.ui.util

import java.math.BigDecimal
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Formats {

    private var locale = Locale("pt", "BR")
    private val formatDayMonthSimplified = SimpleDateFormat("EEE',' MMM dd '─' HH:mm", locale)
    private val formatDayMonthExtensive = SimpleDateFormat("EEEE',' MMMM dd 'às' HH:mm", locale)
    private val formatMoney = NumberFormat.getCurrencyInstance(locale)

    private fun typeConversion(time: Long?) = time?.let { Date(it) } ?: run { "" }

    fun longToDateSimplified(time: Long?): String {
        val date = typeConversion(time)
        return formatDayMonthSimplified.format(date)
    }

    fun longToDateExtensive(time: Long?): String {
        val date = typeConversion(time)
        return formatDayMonthExtensive.format(date)
    }

    fun money(value: BigDecimal?): String {
        return value?.let { formatMoney.format(it.toDouble()) } ?: run { "" }
    }

}