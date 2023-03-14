package com.example.demoviperbindview.domain.usecase

import com.example.demoviperbindview.data.di.IoDispatcher
import com.example.demoviperbindview.data.model.Crew
import com.example.demoviperbindview.data.network.GenericResponse
import com.example.demoviperbindview.data.service.remote.CrewApi
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetListCrewUseCase @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val api: CrewApi
) : UseCase<GenericResponse<List<Crew>>, UseCase.None>(ioDispatcher) {

    override suspend fun execute(params: None): GenericResponse<List<Crew>> {
        return api.getCrews()
    }
}