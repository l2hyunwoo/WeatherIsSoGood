package co.spoonradio.recruit.data.datasource.remote.datasource

import co.spoonradio.recruit.data.datasource.remote.api.WeatherApi
import co.spoonradio.recruit.data.entity.Weather
import javax.inject.Inject

class WeatherDataSourceImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherDataSource {
    override suspend fun getWeatherOf(id: Int): Weather =
        weatherApi.getWeatherOf(id, WEATHER_API_KEY)

    companion object {
        private const val WEATHER_API_KEY = "2c84cd67b34531e16eea7aef34fba077"
    }
}