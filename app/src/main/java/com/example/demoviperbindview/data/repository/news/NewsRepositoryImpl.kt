package com.example.demoviperbindview.data.repository.news

import com.example.demoviperbindview.data.model.BaseModel
import com.example.demoviperbindview.data.model.News
import com.example.demoviperbindview.data.network.GenericResponse
import com.example.demoviperbindview.data.service.remote.NewsApi
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {

    override suspend fun getNews(q: String?, page: Int?): GenericResponse<BaseModel<List<News>>> {
        return newsApi.getNews(q, page)
    }
}