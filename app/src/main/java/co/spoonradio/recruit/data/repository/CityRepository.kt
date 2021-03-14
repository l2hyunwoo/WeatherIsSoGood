package co.spoonradio.recruit.data.repository

import co.spoonradio.recruit.data.entity.City

interface CityRepository {
    suspend fun getCityData(): List<City>
    suspend fun searchCities(query: String): List<City>
}