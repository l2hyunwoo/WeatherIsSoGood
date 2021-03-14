package co.spoonradio.recruit.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

const val KELVIN_CONSTANT = 273.15

@BindingAdapter("app:srcFromUrl")
fun ImageView.setSrcFromUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .into(this)
}

@BindingAdapter("app:setCelsiusTemperature")
fun TextView.setCelsiusTemperature(temperature: Double) {
    val temperatureString = "${temperature - KELVIN_CONSTANT}°C"
    this.text = temperatureString
}

@BindingAdapter("app:setWeatherIcon")
fun ImageView.setWeatherIcon(icon: String) {
    val url = "http://openweathermap.org/img/wn/${icon}@2x.png"
    Glide.with(this.context)
        .load(url)
        .into(this)
}