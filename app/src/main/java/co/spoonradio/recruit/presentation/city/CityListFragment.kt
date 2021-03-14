package co.spoonradio.recruit.presentation.city

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import co.spoonradio.recruit.R
import co.spoonradio.recruit.base.BindingFragment
import co.spoonradio.recruit.data.entity.City
import co.spoonradio.recruit.databinding.FragmentCityListBinding
import co.spoonradio.recruit.presentation.city.adapter.CityAdapter
import co.spoonradio.recruit.presentation.detail.DetailActivity

class CityListFragment : BindingFragment<FragmentCityListBinding>(R.layout.fragment_city_list) {
    private val cityViewModel: CityViewModel by activityViewModels()
    private val cityAdapter: CityAdapter by lazy { CityAdapter(provideItemClickListener()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setAdapter()
        subscribeData()
        return binding.root
    }

    private fun subscribeData() {
        with(cityViewModel) {
            cityList.observe(viewLifecycleOwner) { cityAdapter.submitList(it) }
        }
    }

    private fun setAdapter() {
        binding.rvCityList.adapter = cityAdapter
        cityViewModel.getCityInfo()
    }

    private fun provideItemClickListener(): CityAdapter.OnClickListener {
        return object : CityAdapter.OnClickListener {
            override fun itemClickListener(city: City) {
                val intent = Intent(requireActivity(), DetailActivity::class.java)
                intent.putExtra("city", city)
                startActivity(intent)
            }
        }
    }
}