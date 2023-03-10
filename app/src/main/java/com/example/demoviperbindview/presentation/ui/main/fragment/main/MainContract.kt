package com.example.demoviperbindview.presentation.ui.main.fragment.main

import androidx.navigation.NavDirections

interface MainContract {

    interface Presenter {

        fun onBackClicked()

        fun onItemClicked(action: NavDirections)

        fun onViewCreated()

        fun onCreate()
    }

    interface Interactor {
        fun getData(onSuccess: (String) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun finish()
        fun openDetailActivity(action: NavDirections)
    }
}