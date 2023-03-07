package com.example.demoviperbindview.detail

interface DetailContract {
    interface View

    interface Presenter {
        fun bindView(view: View)

        fun unbindView()

        fun onBackClicked()
    }

    interface Router {
        fun finish()
    }
}