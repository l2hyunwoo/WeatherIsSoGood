package co.spoonradio.recruit.data.datasource.local

import android.content.Context
import co.spoonradio.recruit.data.entity.City
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CityDataSourceImpl(private val context: Context) : CityDataSource {
    override suspend fun fetchCityInfo(): List<City> {
        val cityTypeInfo = object : TypeToken<List<City>>() {}.type
        val jsonString = runCatching {
            context.assets
                .open("citylist.json")
                .bufferedReader()
                .use { it.readText() }
        }
        return Gson().fromJson(jsonString.getOrNull(), cityTypeInfo)
    }
}