package com.example.evaluationkotlin.domain.models

data class Weather (
    val id: Int,
    val day: String,
    val startHour: String,
    val endHour: String,
    val weatherType: String
)