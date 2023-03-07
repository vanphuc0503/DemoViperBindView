package com.example.demoviperbindview.detail

class DetailRouter(private val activity: DetailFragment) : DetailContract.Router {

    override fun finish() {
        activity.requireActivity().supportFragmentManager.popBackStack()
    }
}