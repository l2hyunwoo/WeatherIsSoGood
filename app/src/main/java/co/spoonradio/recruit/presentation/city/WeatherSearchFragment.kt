package co.spoonradio.recruit.presentation.city

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import co.spoonradio.recruit.R
import co.spoonradio.recruit.base.BindingFragment
import co.spoonradio.recruit.data.entity.City
import co.spoonradio.recruit.databinding.FragmentWeatherSearchBinding
import co.spoonradio.recruit.presentation.city.adapter.CityAdapter
import co.spoonradio.recruit.presentation.detail.DetailActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch

class WeatherSearchFragment :
    BindingFragment<FragmentWeatherSearchBinding>(R.layout.fragment_weather_search) {
    private val cityAdapter: CityAdapter by lazy { CityAdapter(provideItemClickListener()) }
    private val cityViewModel: CityViewModel by activityViewModels()

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        initView()
        return binding.root
    }

    @FlowPreview
    @ExperimentalCoroutinesApi
    private fun initView() {
        with(binding) {
            rvSearchResult.adapter = cityAdapter
            etSearchQuery.doAfterTextChanged {
                lifecycleScope.launch { cityViewModel.queryChannel.send(it.toString()) }
            }
        }
        cityViewModel.searchResult.observe(viewLifecycleOwner) { handleSearchResult(it) }
    }

    private fun handleSearchResult(searchResult: SearchResult) {
        when (searchResult) {
            is ValidResult -> {
                with(binding) {
                    rvSearchResult.visibility = View.VISIBLE
                    txtSearchWarning.visibility = View.GONE
                }
                cityAdapter.submitList(searchResult.result)
            }
            is Empty -> {
                with(binding) {
                    rvSearchResult.visibility = View.GONE
                    txtSearchWarning.visibility = View.VISIBLE
                }
            }
            else -> {
                with(binding) {
                    rvSearchResult.visibility = View.GONE
                    txtSearchWarning.visibility = View.GONE
                }
            }
        }
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