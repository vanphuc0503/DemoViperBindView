package com.example.demoviperbindview.presentation.ui.main.fragment.detail

import androidx.navigation.NavController
import androidx.navigation.NavDirections

class DetailRouter(private val controller: NavController) : DetailContract.Router {

    override fun finish() {
        controller.popBackStack()
    }

    override fun openHome(action: NavDirections) {
        controller.navigate(action)
    }
}