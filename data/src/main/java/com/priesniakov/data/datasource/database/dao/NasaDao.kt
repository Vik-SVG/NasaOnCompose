package com.priesniakov.data.datasource.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.priesniakov.data.model.Astronomy

@Dao
interface NasaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAstronomyData(astronomyList: List<Astronomy>)

    @Query("DELETE FROM ${Astronomy.TABLE_NAME}")
    suspend fun deleteAllAstronomyData()

    @Query("SELECT * FROM ${Astronomy.TABLE_NAME}")
    suspend fun getAllAstronomyData(): List<Astronomy>

}