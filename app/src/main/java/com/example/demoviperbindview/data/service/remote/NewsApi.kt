package com.example.demoviperbindview.data.service.remote

import com.example.demoviperbindview.data.model.BaseModel
import com.example.demoviperbindview.data.model.News
import com.example.demoviperbindview.data.network.GenericResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("q") q: String? = null,
        @Query("page") page: Int? = null
    ): GenericResponse<BaseModel<List<News>>>
}