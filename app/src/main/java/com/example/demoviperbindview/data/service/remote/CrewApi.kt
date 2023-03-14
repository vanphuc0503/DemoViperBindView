package com.example.demoviperbindview.data.service.remote

import com.example.demoviperbindview.data.model.Crew
import com.example.demoviperbindview.data.network.GenericResponse
import retrofit2.http.GET

interface CrewApi {
    @GET("crew")
    suspend fun getCrews(): GenericResponse<List<Crew>>
}