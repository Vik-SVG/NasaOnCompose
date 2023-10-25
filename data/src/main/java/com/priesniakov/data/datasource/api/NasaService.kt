package com.priesniakov.data.datasource.api

import com.priesniakov.data.model.Astronomy
import retrofit2.Response
import retrofit2.http.GET

interface NasaService {

    @GET("planetary/apod?count=20")
    suspend fun getPicturesOfTheDay(
//        @Query("api_key") apiKey: String
    ): Response<List<Astronomy>>

}