package com.priesniakov.nasaoncompose.di

import android.content.Context
import com.priesniakov.data.datasource.database.NasaDataBase
import com.priesniakov.data.datasource.database.dao.NasaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalModule {

    @Singleton
    @Provides
    fun provideNasaDatabase(@ApplicationContext context: Context): NasaDataBase {
        return NasaDataBase.getInstance(context)
    }

    @Provides
    fun provideNasaDao(appDatabase: NasaDataBase): NasaDao {
        return appDatabase.nasaDao()
    }

}