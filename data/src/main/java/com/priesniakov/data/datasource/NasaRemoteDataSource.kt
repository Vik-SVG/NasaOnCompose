package com.priesniakov.data.datasource

import com.priesniakov.data.datasource.api.NasaService
import com.priesniakov.data.datasource.core.BaseDataSource
import com.priesniakov.data.model.Astronomy
import com.priesniakov.data.model.core.Resource
import javax.inject.Inject
import javax.inject.Singleton

interface NasaRemoteDataSource {
    suspend fun getAstronomyDataFromRemote(): Resource<List<Astronomy>>
}

@Singleton
class NasaRemoteDataSourceImpl @Inject constructor(private val nasaService: NasaService) :
    BaseDataSource(),
    NasaRemoteDataSource {
    override suspend fun getAstronomyDataFromRemote(): Resource<List<Astronomy>> =
        getResultsFromRemote { nasaService.getPicturesOfTheDay() }

}