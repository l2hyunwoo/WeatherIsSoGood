package co.spoonradio.recruit.presentation.city.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import co.spoonradio.recruit.presentation.city.CityListFragment
import co.spoonradio.recruit.presentation.city.WeatherSearchFragment

class MenuPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CityListFragment()
            1 -> WeatherSearchFragment()
            else -> throw IllegalArgumentException("Wrong Position $position")
        }
    }
}