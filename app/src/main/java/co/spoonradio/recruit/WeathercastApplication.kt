package co.spoonradio.recruit

import android.app.Application
import co.spoonradio.recruit.util.PixelRatio

class WeathercastApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initPixelUtil()
    }

    private fun initPixelUtil() {
        pixelRatio = PixelRatio(this)
    }

    companion object {
        lateinit var pixelRatio: PixelRatio
    }
}