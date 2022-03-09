package br.com.cabral.eventos.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val id: String,
    val title: String,
    val image: String,
    val description: String,
    val date: Long,
    val price: Double,
    val latitude: Double,
    val longitude: Double,
    val people: List<CheckIn>
) : Parcelable