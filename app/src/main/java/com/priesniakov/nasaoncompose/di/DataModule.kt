package com.priesniakov.nasaoncompose.di

import com.priesniakov.data.datasource.NasaCacheDataSource
import com.priesniakov.data.datasource.NasaCacheDataSourceImpl
import com.priesniakov.data.datasource.NasaLocalDataSource
import com.priesniakov.data.datasource.NasaLocalDataSourceImpl
import com.priesniakov.data.datasource.NasaRemoteDataSource
import com.priesniakov.data.datasource.NasaRemoteDataSourceImpl
import com.priesniakov.data.repository.ApodRepository
import com.priesniakov.data.repository.ApodRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun provideApodRepository(repo: ApodRepositoryImpl): ApodRepository

    @Binds
    abstract fun provideNasaRemoteDataSource(dataSource: NasaRemoteDataSourceImpl): NasaRemoteDataSource

    @Binds
    abstract fun provideNasaLocalDatasource(useCase: NasaLocalDataSourceImpl): NasaLocalDataSource

    @Binds
    abstract fun provideNasaCacheDataSource(useCase: NasaCacheDataSourceImpl): NasaCacheDataSource

}