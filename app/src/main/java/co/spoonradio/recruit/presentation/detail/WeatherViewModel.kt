package co.spoonradio.recruit.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.spoonradio.recruit.data.entity.Weather
import co.spoonradio.recruit.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _weatherInfo = MutableLiveData<Weather>()
    val weatherInfo: LiveData<Weather>
        get() = _weatherInfo

    fun getWeatherOf(id: Int) {
        viewModelScope.launch {
            runCatching { weatherRepository.getWeatherOf(id) }
                .onSuccess { _weatherInfo.value = it }
                .onFailure { it.printStackTrace() }
        }
    }
}