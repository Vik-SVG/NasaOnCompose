package com.priesniakov.core.network

import okhttp3.Interceptor
import okhttp3.Response

class DefaultInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Accept", "application/json")
        builder.addHeader("Content-Type", "application/json")
        builder.addHeader("api-key", apiKey)
        return chain.proceed(builder.build())
    }
}