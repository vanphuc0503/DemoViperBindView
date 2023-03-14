package com.example.demoviperbindview.data.repository.crew

import com.example.demoviperbindview.data.model.Crew
import com.example.demoviperbindview.data.network.GenericResponse

interface CrewRepository {
    suspend fun getCrews(): GenericResponse<List<Crew>>
}