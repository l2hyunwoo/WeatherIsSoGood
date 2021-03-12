package co.spoonradio.recruit.presentation.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.spoonradio.recruit.data.entity.City
import co.spoonradio.recruit.data.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val cityRepository: CityRepository
) : ViewModel() {
    private val _cityList = MutableLiveData<List<City>>()
    val cityList: LiveData<List<City>>
        get() = _cityList

    fun getCityInfo() {
        viewModelScope.launch {
            _cityList.value = cityRepository.getCityData()
        }
    }
}