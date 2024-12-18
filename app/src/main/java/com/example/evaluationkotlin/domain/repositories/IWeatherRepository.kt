package com.example.evaluationkotlin.domain.repositories

import com.example.evaluationkotlin.domain.models.Weather

interface IWeatherRepository {
    suspend fun getWeathers(): List<Weather>
    suspend fun getWeatherById(id: Int): Weather
}