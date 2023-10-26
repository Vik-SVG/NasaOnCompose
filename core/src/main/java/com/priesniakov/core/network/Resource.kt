package com.priesniakov.core.network

sealed class Resource<out T> {
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error<E>(val message: String) : Resource<E>()
    data object Loading : Resource<Nothing>()
    data object Idle : Resource<Nothing>()
}
