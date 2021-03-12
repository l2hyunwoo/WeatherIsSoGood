package co.spoonradio.recruit.data.datasource.remote.datasource

import co.spoonradio.recruit.data.entity.Weather

interface WeatherDataSource {
    suspend fun getWeatherOf(id: Int): Weather
}