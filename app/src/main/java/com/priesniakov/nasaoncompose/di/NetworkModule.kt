package com.priesniakov.nasaoncompose.di

import com.google.gson.GsonBuilder
import com.priesniakov.core.network.DefaultInterceptor
import com.priesniakov.data.datasource.api.NasaService
import com.priesniakov.nasaoncompose.BuildConfig
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


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()


    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
        builder.retryOnConnectionFailure(true)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        builder.addInterceptor(DefaultInterceptor(BuildConfig.API_KEY))
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideNasaApi(retrofit: Retrofit) =
        retrofit.create(NasaService::class.java)

    companion object {
        private const val TIMEOUT_SEC: Long = 10
    }
}