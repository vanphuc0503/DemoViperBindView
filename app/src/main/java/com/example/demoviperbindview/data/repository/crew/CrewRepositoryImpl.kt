package com.example.demoviperbindview.data.repository.crew

import com.example.demoviperbindview.data.model.Crew
import com.example.demoviperbindview.data.network.GenericResponse
import com.example.demoviperbindview.data.service.remote.CrewApi
import javax.inject.Inject

class CrewRepositoryImpl @Inject constructor(
    private val crewApi: CrewApi
) : CrewRepository {

    override suspend fun getCrews(): GenericResponse<List<Crew>> {
        return crewApi.getCrews()
    }
}