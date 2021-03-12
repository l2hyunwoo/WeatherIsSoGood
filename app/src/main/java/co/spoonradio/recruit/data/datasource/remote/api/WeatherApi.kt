package co.spoonradio.recruit.data.datasource.remote.api

import co.spoonradio.recruit.data.entity.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeatherOf(
        @Query("id") cityId: Int,
        @Query("appid") apiKey: String
    ): Weather
}