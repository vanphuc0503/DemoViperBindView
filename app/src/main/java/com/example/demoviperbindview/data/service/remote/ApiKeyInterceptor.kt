package com.example.demoviperbindview.data.service.remote

import com.example.demoviperbindview.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val httpUrl = original.url
        val url = httpUrl.newBuilder()
            .addQueryParameter("apiKey", BuildConfig.NEWS_API)
            .build()
        val request: Request = original.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}