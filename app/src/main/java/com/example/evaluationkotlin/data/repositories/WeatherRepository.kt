package com.example.evaluationkotlin.data.repositories

import com.example.evaluationkotlin.domain.models.Weather
import com.example.evaluationkotlin.domain.repositories.IWeatherRepository

/**
 * Permet de fournir les données météo au reste de l'application, fait le lien avec les endpoints API
 */
class WeatherRepository : IWeatherRepository {
    /**
     * @param id: Récupère un entier représentant l'identifiant d'une information météo.
     * @return: Une météo.
     */
    override suspend fun getWeatherById(id: Int): Weather {
        val weathers = getWeathers()
        return weathers.find { it.id == id } ?: Weather(id = 0, day = "unknown", startHour = "unknown", endHour = "unknown", weatherType = "unknown")
    }

    /**
     * @return: Une liste d'information météo (En static, les call API ne fonctionne pas.)
     */
    override suspend fun getWeathers(): List<Weather> {
        var weatherList: List<Weather>  = listOf(
            Weather(
                id = 0,
                day = "10-10-2025",
                startHour = "14:00",
                endHour = "14:02",
                weatherType = "Rain"
            ),
            Weather(
                id = 1,
                day = "02-05-2025",
                startHour = "15:00",
                endHour = "15:26",
                weatherType = "Sunny"
            ),
            Weather(
                id = 2,
                day = "04-05-2025",
                startHour = "12:00",
                endHour = "12:30",
                weatherType = "Cloudy"
            ),
            Weather(
                id = 3,
                day = "15-07-2025",
                startHour = "10:30",
                endHour = "11:00",
                weatherType = "Windy"
            ),
            Weather(
                id = 4,
                day = "20-08-2025",
                startHour = "13:45",
                endHour = "14:15",
                weatherType = "Thunderstorm"
            ),
            Weather(
                id = 5,
                day = "03-09-2025",
                startHour = "09:00",
                endHour = "09:30",
                weatherType = "Foggy"
            ),
            Weather(
                id = 6,
                day = "18-11-2025",
                startHour = "16:15",
                endHour = "16:45",
                weatherType = "Snowy"
            ),
            Weather(
                id = 7,
                day = "25-12-2025",
                startHour = "11:30",
                endHour = "12:00",
                weatherType = "Partly Cloudy"
            ),
            Weather(
                id = 8,
                day = "01-01-2026",
                startHour = "00:00",
                endHour = "00:30",
                weatherType = "Clear"
            ),
            Weather(
                id = 9,
                day = "14-02-2026",
                startHour = "18:00",
                endHour = "18:30",
                weatherType = "Drizzle"
            )
        )
        return weatherList
    }
}
