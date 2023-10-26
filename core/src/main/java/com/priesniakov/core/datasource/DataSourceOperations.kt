package com.priesniakov.core.datasource

import com.priesniakov.core.network.Resource
import retrofit2.Response

interface DataSourceOperations {

    suspend fun performSingleAction(call: suspend () -> Unit): Resource<Boolean>

    suspend fun <T> performSingleActionWithResult(call: suspend () -> T): Resource<T>
    suspend fun <T> getResultsFromRemote(call: suspend () -> Response<T>): Resource<T>

}