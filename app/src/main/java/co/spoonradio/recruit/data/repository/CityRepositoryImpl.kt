package co.spoonradio.recruit.data.repository

import co.spoonradio.recruit.data.datasource.local.CityDataSource
import co.spoonradio.recruit.data.entity.City
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val dataSource: CityDataSource
) : CityRepository {
    override suspend fun getCityData(): List<City> =
        dataSource.fetchCityInfo()

    override suspend fun searchCities(query: String): List<City> =
        dataSource.fetchCityInfo()
            .filter { it.name.contains(query, true) }
            .toList()
}