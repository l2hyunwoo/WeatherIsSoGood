package co.spoonradio.recruit.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:srcFromUrl")
fun ImageView.setSrcFromUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .into(this)
}