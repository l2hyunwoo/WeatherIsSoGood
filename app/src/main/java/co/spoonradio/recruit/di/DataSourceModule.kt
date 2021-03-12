package co.spoonradio.recruit.di

import android.content.Context
import co.spoonradio.recruit.data.datasource.local.CityDataSource
import co.spoonradio.recruit.data.datasource.local.CityDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideCityDataSource(@ApplicationContext context: Context): CityDataSource =
        CityDataSourceImpl(context)
}