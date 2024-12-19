package com.example.evaluationkotlin.ui.screens.detailsscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluationkotlin.data.repositories.WeatherRepository
import com.example.evaluationkotlin.domain.models.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsScreenViewModel(private val weatherRepository: WeatherRepository = WeatherRepository()) : ViewModel() {
    private val _state = MutableStateFlow(DetailsScreenState())
    val state: StateFlow<DetailsScreenState> = _state

    fun loadWeather(id: Int) {
        viewModelScope.launch {
            try {
                val weather = weatherRepository.getWeatherById(id)
                _state.value = DetailsScreenState(weather = weather)
            } catch (e: Exception) {
                _state.value = DetailsScreenState(error = "Erreur lors du chargement des données météo")
            }
        }
    }
}

data class DetailsScreenState(
    val weather: Weather? = null,
    val error: String? = null
)
