package co.spoonradio.recruit.data.datasource.local

import co.spoonradio.recruit.data.entity.City

interface CityDataSource {
    suspend fun fetchCityInfo(): List<City>
}