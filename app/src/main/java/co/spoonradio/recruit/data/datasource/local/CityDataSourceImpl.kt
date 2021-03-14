package co.spoonradio.recruit.data.datasource.local

import android.content.Context
import co.spoonradio.recruit.data.entity.City
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CityDataSourceImpl @Inject constructor(
    private val context: Context
) : CityDataSource {
    override suspend fun fetchCityInfo(): List<City> {
        return withContext(Dispatchers.IO) {
            val cityTypeInfo = object : TypeToken<List<City>>() {}.type
            val cityListJson = runCatching {
                context.assets
                    .open("citylist.json")
                    .bufferedReader()
                    .use { it.readText() }
            }
            Gson().fromJson(cityListJson.getOrNull(), cityTypeInfo)
        }
    }
}