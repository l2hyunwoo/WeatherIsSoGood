package co.spoonradio.recruit.data.repository

import co.spoonradio.recruit.data.entity.Weather

interface WeatherRepository {
    suspend fun getWeatherOf(id: Int): Weather
}