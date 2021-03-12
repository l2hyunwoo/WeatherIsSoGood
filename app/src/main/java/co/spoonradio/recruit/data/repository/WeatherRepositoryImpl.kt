package co.spoonradio.recruit.data.repository

import co.spoonradio.recruit.data.datasource.remote.datasource.WeatherDataSource
import co.spoonradio.recruit.data.entity.Weather
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource
) : WeatherRepository {
    override suspend fun getWeatherOf(id: Int): Weather =
        weatherDataSource.getWeatherOf(id)
}