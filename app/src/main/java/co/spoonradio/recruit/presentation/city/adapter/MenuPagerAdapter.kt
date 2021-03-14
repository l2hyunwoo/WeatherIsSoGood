package co.spoonradio.recruit.presentation.city.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import co.spoonradio.recruit.presentation.city.CityListFragment
import co.spoonradio.recruit.presentation.city.WeatherSearchFragment

class MenuPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CityListFragment()
            1 -> WeatherSearchFragment()
            else -> throw IllegalArgumentException("Wrong Position $position")
        }
    }
}