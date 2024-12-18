package com.example.evaluationkotlin.ui.screens.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluationkotlin.data.repositories.WeatherRepository
import com.example.evaluationkotlin.domain.models.Weather
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

sealed interface MainScreenEvent {
    data class NavigateToDetails(val id: Int) : MainScreenEvent
}

class MainViewModel(private val weatherRepository: WeatherRepository = WeatherRepository()) : ViewModel() {
    private val _state = MutableStateFlow(MainScreenState())
    val state: StateFlow<MainScreenState> = _state

    private val _events = Channel<MainScreenEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadWeatherData()
    }

    private fun loadWeatherData() {
        viewModelScope.launch {
            try {
                val weatherList = weatherRepository.getWeathers()
                _state.value = MainScreenState(weatherList = weatherList)
            } catch (e: Exception) {
                // Gérer l'erreur ici, par exemple en mettant à jour l'état avec un message d'erreur
            }
        }
    }

    fun onWeatherItemClicked(weatherId: Int) {
        viewModelScope.launch {
            _events.send(MainScreenEvent.NavigateToDetails(weatherId))
        }
    }
}

data class MainScreenState(
    val weatherList: List<Weather> = emptyList()
)
