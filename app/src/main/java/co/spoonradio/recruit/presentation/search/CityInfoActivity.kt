package co.spoonradio.recruit.presentation.search

import android.os.Bundle
import co.spoonradio.recruit.R
import co.spoonradio.recruit.base.BindingActivity
import co.spoonradio.recruit.databinding.ActivityCityInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityInfoActivity : BindingActivity<ActivityCityInfoBinding>(R.layout.activity_city_info) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}