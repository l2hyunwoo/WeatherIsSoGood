package co.spoonradio.recruit.presentation.city

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import co.spoonradio.recruit.R
import co.spoonradio.recruit.base.BindingActivity
import co.spoonradio.recruit.databinding.ActivityCityInfoBinding
import co.spoonradio.recruit.presentation.city.adapter.CityAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityInfoActivity : BindingActivity<ActivityCityInfoBinding>(R.layout.activity_city_info) {
    private val cityViewModel: CityViewModel by viewModels()
    private val cityAdapter: CityAdapter by lazy { CityAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        setAdapter()
        subscribeData()
    }

    private fun subscribeData() {
        with(cityViewModel) {
            Log.d("TAG", "Here sub")
            cityList.observe(this@CityInfoActivity) {
                Log.d("TAG", it.toString())
                cityAdapter.submitList(it)
            }
        }
    }

    private fun setAdapter() {
        binding.rvCityList.adapter = cityAdapter
        cityViewModel.getCityInfo()
    }
}