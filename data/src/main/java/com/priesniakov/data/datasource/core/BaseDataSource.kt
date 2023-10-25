package com.priesniakov.data.datasource.core

import android.util.Log
import com.priesniakov.data.model.core.Resource
import retrofit2.Response

abstract class BaseDataSource {
    protected suspend fun <T> getResultsFromRemote(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                val body = response.body()
                Log.i("BaseDataSource", body.toString())
                if (body != null) return Resource.Success(body)
            }
            return networkError(" ${response.code()} ${response.message()} ")
        } catch (e: Exception) {
            return networkError(e.message ?: e.toString())
        }
    }

    protected suspend fun performSingleAction(call: suspend () -> Unit): Resource<Boolean> {
        return try {
            call.invoke()
            Resource.Success(true)
        } catch (e: Exception) {
            localError(e.message ?: e.toString())
        }
    }

    protected suspend fun <T> performSingleActionWithResult(call: suspend () -> T): Resource<T> {
        return try {
            val result = call.invoke()
            if (result != null) {
                Resource.Success(result)
            } else {
                localError("Action didn't succeed")
            }
        } catch (e: Exception) {
            localError(e.message ?: e.toString())
        }
    }

    private fun <T> networkError(message: String): Resource<T> {
        Log.d(TAG, message)
        return Resource.Error("Network call has failed because of next reason: $message")
    }

    private fun <T> localError(message: String): Resource<T> {
        Log.d(TAG, message)
        return Resource.Error("Local call has failed because of next reason: $message")
    }

    companion object {
        private const val TAG = "DatasourceTag"
    }
}