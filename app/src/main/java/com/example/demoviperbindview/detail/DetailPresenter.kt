package com.example.demoviperbindview.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPresenter @Inject constructor() : ViewModel(), DetailContract.Presenter {

    private var router: DetailContract.Router? = null

    fun setRouter(fragment: DetailFragment) {
        router = DetailRouter(fragment)
    }

    override fun onBackClicked() {
        router?.finish()
    }
}