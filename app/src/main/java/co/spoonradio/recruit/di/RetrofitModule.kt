package co.spoonradio.recruit.di

import co.spoonradio.recruit.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    private fun provideClient() = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(provideLoggingInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideRetrofitObject(): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.WEATHER_API_KEY).client(provideClient())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}