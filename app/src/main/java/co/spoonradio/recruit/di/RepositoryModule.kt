package co.spoonradio.recruit.di

import co.spoonradio.recruit.data.datasource.local.CityDataSource
import co.spoonradio.recruit.data.repository.CityRepository
import co.spoonradio.recruit.data.repository.CityRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCityRepository(cityDataSource: CityDataSource): CityRepository =
        CityRepositoryImpl(cityDataSource)
}