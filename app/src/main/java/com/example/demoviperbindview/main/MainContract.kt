package com.example.demoviperbindview.main

interface MainContract {

    interface Presenter {

        fun onBackClicked()

        fun onItemClicked()

        fun onViewCreated()

        fun onCreate()
    }

    interface Interactor {
        fun getData(onSuccess: (String) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun finish()
        fun openDetailActivity()
    }
}