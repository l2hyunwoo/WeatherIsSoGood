package co.spoonradio.recruit.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlin.math.floor

const val KELVIN_CONSTANT = 273.15

@BindingAdapter("app:setCelsiusTemperature")
fun TextView.setCelsiusTemperature(temperature: Double) {
    val temperatureString = "${floorOneSpot(temperature - KELVIN_CONSTANT)}°C"
    this.text = temperatureString
}

@BindingAdapter("app:setWeatherIcon")
fun ImageView.setWeatherIcon(icon: String?) {
    if (!icon.isNullOrEmpty()) {
        val url = "http://openweathermap.org/img/wn/${icon}@2x.png"
        Glide.with(this.context)
            .load(url)
            .into(this)
    }
}

fun floorOneSpot(value: Double) = floor(value * 10) / 10