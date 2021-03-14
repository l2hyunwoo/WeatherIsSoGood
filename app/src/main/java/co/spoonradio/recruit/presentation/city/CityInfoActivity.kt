package co.spoonradio.recruit.presentation.city

import android.graphics.Color
import android.os.Bundle
import co.spoonradio.recruit.R
import co.spoonradio.recruit.base.BindingActivity
import co.spoonradio.recruit.databinding.ActivityCityInfoBinding
import co.spoonradio.recruit.presentation.city.adapter.MenuPagerAdapter
import co.spoonradio.recruit.util.StatusBarUtil
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityInfoActivity : BindingActivity<ActivityCityInfoBinding>(R.layout.activity_city_info) {
    private val menuPagerAdapter: MenuPagerAdapter by lazy { MenuPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        StatusBarUtil.setStatusBar(this, Color.TRANSPARENT, false)
        setAdapter()
    }

    private fun setAdapter() {
        binding.vpCityMenu.adapter = menuPagerAdapter
        TabLayoutMediator(binding.tabCityMenu, binding.vpCityMenu) { tab, position ->
            tab.text = Header.of(position)
        }.attach()
    }
}

enum class Header(
    private val position: Int,
    private val title: String
) {
    FIRST(0, "LIST"),
    SECOND(1, "SEARCH");

    private fun hasPosition(position: Int): Boolean =
        this.position == position

    companion object {
        fun of(position: Int): String {
            return values().find { it.hasPosition(position) }?.title
                ?: throw IllegalArgumentException("포지션 값이 잘못되었습니다. position: $position")
        }
    }
}