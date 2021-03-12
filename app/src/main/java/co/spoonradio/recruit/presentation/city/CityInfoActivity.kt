package co.spoonradio.recruit.presentation.city

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import co.spoonradio.recruit.R
import co.spoonradio.recruit.base.BindingActivity
import co.spoonradio.recruit.data.entity.City
import co.spoonradio.recruit.databinding.ActivityCityInfoBinding
import co.spoonradio.recruit.presentation.city.adapter.CityAdapter
import co.spoonradio.recruit.presentation.detail.DetailActivity
import co.spoonradio.recruit.util.StatusBarUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityInfoActivity : BindingActivity<ActivityCityInfoBinding>(R.layout.activity_city_info) {
    private val cityViewModel: CityViewModel by viewModels()
    private val cityAdapter: CityAdapter by lazy { CityAdapter(provideItemClickListener()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        StatusBarUtil.setStatusBar(this, Color.TRANSPARENT, false)
        setAdapter()
        subscribeData()
    }

    private fun subscribeData() {
        with(cityViewModel) {
            cityList.observe(this@CityInfoActivity) { cityAdapter.submitList(it) }
        }
    }

    private fun setAdapter() {
        binding.rvCityList.adapter = cityAdapter
        cityViewModel.getCityInfo()
    }

    private fun provideItemClickListener(): CityAdapter.OnClickListener {
        return object : CityAdapter.OnClickListener {
            override fun itemClickListener(city: City) {
                val intent = Intent(this@CityInfoActivity, DetailActivity::class.java)
                startActivity(intent)
            }
        }
    }
}