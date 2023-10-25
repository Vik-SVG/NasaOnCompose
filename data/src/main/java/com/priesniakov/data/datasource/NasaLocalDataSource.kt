package com.priesniakov.data.datasource

import com.priesniakov.data.datasource.core.BaseDataSource
import com.priesniakov.data.datasource.database.dao.NasaDao
import com.priesniakov.data.model.Astronomy
import com.priesniakov.data.model.core.Resource
import javax.inject.Inject
import javax.inject.Singleton

interface NasaLocalDataSource {
    suspend fun clearAstronomyDataFromLocal(): Resource<Boolean>
    suspend fun saveAstronomyDataToLocal(newAstronomyData: List<Astronomy>)
    suspend fun getAstronomyDataFromLocal(): Resource<List<Astronomy>>
}

@Singleton
class NasaLocalDataSourceImpl @Inject constructor(private val nasaDao: NasaDao) : BaseDataSource(),
    NasaLocalDataSource {
    override suspend fun clearAstronomyDataFromLocal() = performSingleAction {
        nasaDao.deleteAllAstronomyData()
    }

    override suspend fun saveAstronomyDataToLocal(newAstronomyData: List<Astronomy>) {
        performSingleAction { nasaDao.saveAstronomyData(newAstronomyData) }
    }

    override suspend fun getAstronomyDataFromLocal(): Resource<List<Astronomy>> =
        performSingleActionWithResult { nasaDao.getAllAstronomyData() }
}