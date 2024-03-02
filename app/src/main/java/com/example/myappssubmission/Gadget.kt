package com.example.myappssubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gadget(
    val name: String,
    val description: String,
    val photo: String,
    val display: String,
    val battery: String
) : Parcelable