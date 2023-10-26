package com.priesniakov.core.usecase

import com.priesniakov.core.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface FlowableUseCase {
    operator fun <R> invoke(networkCall: suspend () -> Resource<R>): Flow<Resource<R>>
}

class FlowableUseCaseImpl : FlowableUseCase {
    override fun <R> invoke(networkCall: suspend () -> Resource<R>): Flow<Resource<R>> {
        return flow {
            emit(Resource.Loading)
            val networkResponse = networkCall.invoke()
            if (networkResponse is Resource.Success) {
                emit(networkResponse)
            } else if (networkResponse is Resource.Error) {
                emit(Resource.Error(networkResponse.message))
            }
        }.flowOn(Dispatchers.IO)
    }

}