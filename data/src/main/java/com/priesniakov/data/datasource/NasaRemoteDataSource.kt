package com.priesniakov.data.datasource

import com.priesniakov.data.datasource.api.NasaService
import com.priesniakov.core.datasource.SafeDataSourceOperations
import com.priesniakov.core.datasource.DataSourceOperations
import com.priesniakov.core.network.Resource
import com.priesniakov.data.model.Astronomy
import javax.inject.Inject
import javax.inject.Singleton

interface NasaRemoteDataSource {
    suspend fun getAstronomyDataFromRemote(): Resource<List<Astronomy>>
}

@Singleton
class NasaRemoteDataSourceImpl @Inject constructor(private val nasaService: NasaService) :
    DataSourceOperations by SafeDataSourceOperations(),
    NasaRemoteDataSource {
    override suspend fun getAstronomyDataFromRemote(): Resource<List<Astronomy>> =
        getResultsFromRemote { nasaService.getPicturesOfTheDay() }

}