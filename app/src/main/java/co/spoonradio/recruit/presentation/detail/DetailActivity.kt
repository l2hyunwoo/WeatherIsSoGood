package co.spoonradio.recruit.presentation.detail

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import co.spoonradio.recruit.R
import co.spoonradio.recruit.base.BindingActivity
import co.spoonradio.recruit.data.entity.City
import co.spoonradio.recruit.databinding.ActivityDetailBinding
import co.spoonradio.recruit.util.StatusBarUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val weatherViewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBar(this, Color.TRANSPARENT, false)
        val cityInfo = intent.getParcelableExtra<City>("city")
        require(cityInfo != null) { "CityInfo is Null" }
        initView(cityInfo)
        subscibeData()
    }

    private fun subscibeData() {
        with(weatherViewModel) {
            weatherInfo.observe(this@DetailActivity) {
                Toast.makeText(this@DetailActivity, it.sys.country, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initView(city: City) {
        weatherViewModel.getWeatherOf(city.id)
    }
}