package co.spoonradio.recruit.data.datasource.remote.datasource

import co.spoonradio.recruit.BuildConfig
import co.spoonradio.recruit.data.datasource.remote.api.WeatherApi
import co.spoonradio.recruit.data.entity.Weather
import javax.inject.Inject

class WeatherDataSourceImpl @Inject constructor(
    private val weatherApi: WeatherApi
): WeatherDataSource {
    override suspend fun getWeatherOf(id: Int): Weather =
        weatherApi.getWeatherOf(id, BuildConfig.WEATHER_API_KEY)
}