package co.spoonradio.recruit.presentation.detail

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import co.spoonradio.recruit.R
import co.spoonradio.recruit.base.BindingActivity
import co.spoonradio.recruit.databinding.ActivityDetailBinding
import co.spoonradio.recruit.util.StatusBarUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val weatherViewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBar(this, Color.TRANSPARENT, false)
    }
}