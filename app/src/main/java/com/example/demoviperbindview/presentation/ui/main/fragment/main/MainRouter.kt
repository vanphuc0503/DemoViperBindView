package com.example.demoviperbindview.presentation.ui.main.fragment.main

import androidx.navigation.NavController
import androidx.navigation.NavDirections

class MainRouter(private val controller: NavController) : MainContract.Router {

    override fun finish() {
        controller.popBackStack()
    }

    override fun openDetailActivity(action: NavDirections) {
        controller.navigate(action)
    }
}