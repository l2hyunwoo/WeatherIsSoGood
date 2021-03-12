package co.spoonradio.recruit.presentation.city.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.spoonradio.recruit.R
import co.spoonradio.recruit.data.entity.City
import co.spoonradio.recruit.databinding.ItemCityInfoBinding

class CityAdapter : ListAdapter<City, CityAdapter.CityViewHolder>(CityDiffUtil) {
    class CityViewHolder(private val binding: ItemCityInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(city: City) {
            binding.city = city
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCityInfoBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_city_info, parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object CityDiffUtil : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean =
            oldItem == newItem
    }
}