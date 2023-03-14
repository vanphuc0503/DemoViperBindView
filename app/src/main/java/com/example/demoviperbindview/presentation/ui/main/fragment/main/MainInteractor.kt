package com.example.demoviperbindview.presentation.ui.main.fragment.main

import com.example.demoviperbindview.data.model.Crew
import com.example.demoviperbindview.data.network.GenericResponse
import com.example.demoviperbindview.domain.usecase.GetListCrewUseCase
import com.example.demoviperbindview.domain.usecase.UseCase
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val getListCrewUseCase: GetListCrewUseCase
) : MainContract.Interactor {

    override suspend fun getCrews(): GenericResponse<List<Crew>> =
        getListCrewUseCase.invoke(UseCase.None())
}