package com.priesniakov.data.datasource

import com.priesniakov.data.datasource.core.BaseDataSource
import com.priesniakov.data.model.Astronomy
import javax.inject.Inject
import javax.inject.Singleton

interface NasaCacheDataSource {
    fun saveAstronomyDataToCache(newAstronomyData: List<Astronomy>)
    fun getAstronomyDataFromCache(): List<Astronomy>
}


@Singleton
class NasaCacheDataSourceImpl @Inject constructor() : BaseDataSource(), NasaCacheDataSource {

    private var astronomyList = ArrayList<Astronomy>()
    override fun saveAstronomyDataToCache(newAstronomyData: List<Astronomy>) {
        astronomyList.clear()
        astronomyList = ArrayList(newAstronomyData)
    }

    override fun getAstronomyDataFromCache(): List<Astronomy> {
        return astronomyList
    }
}