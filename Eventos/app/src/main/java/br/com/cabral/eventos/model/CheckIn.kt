package br.com.cabral.eventos.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckIn(
    val eventId: String,
    val name: String,
    val email: String
) : Parcelable
