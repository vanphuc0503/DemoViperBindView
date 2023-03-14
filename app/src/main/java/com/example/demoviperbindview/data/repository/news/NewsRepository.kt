package com.example.demoviperbindview.data.repository.news

import com.example.demoviperbindview.data.model.BaseModel
import com.example.demoviperbindview.data.model.News
import com.example.demoviperbindview.data.network.GenericResponse

interface NewsRepository {
    suspend fun getNews(q: String?, page: Int? = null): GenericResponse<BaseModel<List<News>>>
}