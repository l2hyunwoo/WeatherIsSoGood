package co.spoonradio.recruit.presentation.city

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.spoonradio.recruit.R
import co.spoonradio.recruit.base.BindingFragment
import co.spoonradio.recruit.databinding.FragmentWeatherSearchBinding

class WeatherSearchFragment : BindingFragment<FragmentWeatherSearchBinding>(R.layout.fragment_weather_search) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }
}