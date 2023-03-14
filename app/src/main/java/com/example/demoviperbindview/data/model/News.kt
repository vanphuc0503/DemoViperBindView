package com.example.demoviperbindview.data.model

data class News(
    val title: String,
    val source: Source? = null,
    val author: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null,
)

data class Source(
    val id: String? = null,
    val name: String? = null
)