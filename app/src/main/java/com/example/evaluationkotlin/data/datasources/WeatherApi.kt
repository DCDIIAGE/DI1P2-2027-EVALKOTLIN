package com.example.evaluationkotlin.data.datasources

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.evaluationkotlin.domain.models.Weather
import retrofit2.http.GET

/**
 * WeatherApi est le point d'entrée entre les repositories et l'API météo externe
 */
object WeatherApi {
    private const val BASE_URL = "https://localhost:5050/"

    val api: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }
}

interface WeatherApiService {
    @GET("Home")
    suspend fun getWeathers(): List<Weather>
}