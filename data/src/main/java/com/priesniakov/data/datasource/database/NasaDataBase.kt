package com.priesniakov.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.priesniakov.data.datasource.database.dao.NasaDao
import com.priesniakov.data.model.Astronomy

@Database(
    entities = [Astronomy::class],
    version = 1,
    exportSchema = false
)
abstract class NasaDataBase : RoomDatabase() {
    abstract fun nasaDao(): NasaDao

    companion object {
        @Volatile
        private var instance: NasaDataBase? = null

        fun getInstance(context: Context): NasaDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): NasaDataBase {
            return Room.databaseBuilder(
                context,
                NasaDataBase::class.java,
                "NasaDatabase"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}