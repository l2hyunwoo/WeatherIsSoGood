package co.spoonradio.recruit.presentation.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.spoonradio.recruit.R
import co.spoonradio.recruit.base.BindingFragment
import co.spoonradio.recruit.databinding.FragmentCityListBinding

class CityListFragment : BindingFragment<FragmentCityListBinding>(R.layout.fragment_city_list) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }
}