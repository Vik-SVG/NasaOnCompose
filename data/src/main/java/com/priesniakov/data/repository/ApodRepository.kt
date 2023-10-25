package com.priesniakov.data.repository

import android.util.Log
import com.priesniakov.data.datasource.NasaCacheDataSource
import com.priesniakov.data.datasource.NasaLocalDataSource
import com.priesniakov.data.datasource.NasaRemoteDataSource
import com.priesniakov.data.model.Astronomy
import com.priesniakov.data.model.core.Resource
import javax.inject.Inject
import javax.inject.Singleton

interface ApodRepository {
    suspend fun getAstronomyDataFromRepository(): Resource<List<Astronomy>>
    suspend fun updateAstronomyDataFromRepository(): Resource<List<Astronomy>>
}

@Singleton
class ApodRepositoryImpl @Inject constructor(
    private val nasaRemoteDataSource: NasaRemoteDataSource,
    private val nasaLocalDataSource: NasaLocalDataSource,
    private val astronomyCacheDataSource: NasaCacheDataSource
) : ApodRepository {
    override suspend fun getAstronomyDataFromRepository(): Resource<List<Astronomy>> {
        return getAstronomyDataFromCache()
    }

    override suspend fun updateAstronomyDataFromRepository(): Resource<List<Astronomy>> {
        val newAstronomyData = getAstronomyDataFromAPI()
        if (newAstronomyData is Resource.Success) {
            nasaLocalDataSource.clearAstronomyDataFromLocal()
            nasaLocalDataSource.saveAstronomyDataToLocal(newAstronomyData.data)
            astronomyCacheDataSource.saveAstronomyDataToCache(newAstronomyData.data)
        }
        return newAstronomyData
    }

    private suspend fun getAstronomyDataFromAPI(): Resource<List<Astronomy>> {
        return nasaRemoteDataSource.getAstronomyDataFromRemote()
    }

    private suspend fun getAstronomyDataFromDB(): List<Astronomy> {

        var astronomyList: List<Astronomy> = listOf()
        try {
            val call = nasaLocalDataSource.getAstronomyDataFromLocal()
            if (call is Resource.Success) {
                astronomyList = call.data
            }
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }

        if (astronomyList.isNotEmpty()) {
            return astronomyList
        } else {
            val apiCall = getAstronomyDataFromAPI()
            if (apiCall is Resource.Success) {
                astronomyList = apiCall.data
                nasaLocalDataSource.saveAstronomyDataToLocal(astronomyList)
            }
        }

        return astronomyList
    }

    private suspend fun getAstronomyDataFromCache(): Resource<List<Astronomy>> {
        lateinit var astronomyList: List<Astronomy>

        try {
            astronomyList = astronomyCacheDataSource.getAstronomyDataFromCache()
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }

        if (astronomyList.isNotEmpty()) {
            return Resource.Success(astronomyList)
        } else {
            astronomyList = getAstronomyDataFromDB()
            astronomyCacheDataSource.saveAstronomyDataToCache(astronomyList)
        }
        return Resource.Success(astronomyList)
    }

    companion object {
        const val TAG = "ApodRepositoryTag"
    }
}