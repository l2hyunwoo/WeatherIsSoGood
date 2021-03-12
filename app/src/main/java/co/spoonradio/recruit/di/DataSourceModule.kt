package co.spoonradio.recruit.di

import android.content.Context
import co.spoonradio.recruit.data.datasource.local.CityDataSource
import co.spoonradio.recruit.data.datasource.local.CityDataSourceImpl
import co.spoonradio.recruit.data.datasource.remote.api.WeatherApi
import co.spoonradio.recruit.data.datasource.remote.datasource.WeatherDataSource
import co.spoonradio.recruit.data.datasource.remote.datasource.WeatherDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideCityDataSource(@ApplicationContext context: Context): CityDataSource =
        CityDataSourceImpl(context)

    @Provides
    @Singleton
    fun provideWeatherDataSource(weatherApi: WeatherApi): WeatherDataSource =
        WeatherDataSourceImpl(weatherApi)
}