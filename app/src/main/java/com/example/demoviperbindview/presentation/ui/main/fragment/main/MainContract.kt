package com.example.demoviperbindview.presentation.ui.main.fragment.main

import androidx.navigation.NavDirections
import com.example.demoviperbindview.data.model.Crew
import com.example.demoviperbindview.data.network.GenericResponse

interface MainContract {

    interface Presenter {

        fun onBackClicked()

        fun onItemClicked(action: NavDirections)

        fun onViewCreated()

        fun onCreate()
    }

    interface Interactor {
        suspend fun getCrews(): GenericResponse<List<Crew>>
    }

    interface Router {
        fun finish()
        fun openDetailActivity(action: NavDirections)
    }
}