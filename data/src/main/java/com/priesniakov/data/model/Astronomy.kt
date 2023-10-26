package com.priesniakov.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = Astronomy.TABLE_NAME)
data class Astronomy(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @SerializedName("title")
    val astronomyTitle: String,
    @SerializedName("date")
    val astronomyDate: String,
    @SerializedName("explanation")
    val astronomyExplanation: String,
    @SerializedName("url")
    val astronomyImage: String?
) {
    companion object {
        const val TABLE_NAME = "astronomy_picture_of_the_day_table"
    }
}