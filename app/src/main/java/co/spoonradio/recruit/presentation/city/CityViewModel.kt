package co.spoonradio.recruit.presentation.city

import android.util.Log
import androidx.lifecycle.*
import co.spoonradio.recruit.data.entity.City
import co.spoonradio.recruit.data.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

sealed class SearchResult
class ValidResult(val result: List<City>) : SearchResult()
object Empty : SearchResult()
object EmptyQuery : SearchResult()
class Error(val error: Throwable) : SearchResult()
object TerminalError : SearchResult()


@HiltViewModel
class CityViewModel @Inject constructor(
    private val cityRepository: CityRepository
) : ViewModel() {
    private val _cityList = MutableLiveData<List<City>>()
    val cityList: LiveData<List<City>>
        get() = _cityList

    @ExperimentalCoroutinesApi
    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    @FlowPreview
    @ExperimentalCoroutinesApi
    val searchResult = queryChannel.asFlow()
        .debounce(500L)
        .mapLatest {
            if(it.isEmpty())
                EmptyQuery
            else {
                val result = withContext(Dispatchers.IO) {cityRepository.searchCities(it) }
                if(result.isNotEmpty()) ValidResult(result)
                else Empty
            }
        }.asLiveData()

    fun getCityInfo() {
        viewModelScope.launch {
            _cityList.value = cityRepository.getCityData()
        }
    }
}