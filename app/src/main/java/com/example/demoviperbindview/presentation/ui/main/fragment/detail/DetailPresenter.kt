package com.example.demoviperbindview.presentation.ui.main.fragment.detail

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPresenter @Inject constructor() : ViewModel(), DetailContract.Presenter {

    private var router: DetailContract.Router? = null

    fun setRouter(controller: NavController) {
        router = DetailRouter(controller)
    }

    override fun onBackClicked() {
        router?.finish()
    }

    override fun onOpenHome(action: NavDirections) {
        router?.openHome(action)
    }
}