package com.example.demoviperbindview.presentation.ui.main.fragment.detail

import androidx.navigation.NavDirections

interface DetailContract {

    interface Presenter {

        fun onBackClicked()

        fun onOpenHome(action: NavDirections)
    }

    interface Router {
        fun finish()

        fun openHome(action: NavDirections)
    }
}