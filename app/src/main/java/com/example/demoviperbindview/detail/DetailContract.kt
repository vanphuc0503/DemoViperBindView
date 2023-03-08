package com.example.demoviperbindview.detail

interface DetailContract {

    interface Presenter {

        fun onBackClicked()
    }

    interface Router {
        fun finish()
    }
}