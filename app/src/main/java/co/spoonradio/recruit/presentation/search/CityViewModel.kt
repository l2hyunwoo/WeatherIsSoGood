package co.spoonradio.recruit.presentation.search

import androidx.lifecycle.ViewModel
import co.spoonradio.recruit.data.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val cityRepository: CityRepository
) : ViewModel()