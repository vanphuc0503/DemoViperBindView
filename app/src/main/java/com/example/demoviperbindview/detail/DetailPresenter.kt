package com.example.demoviperbindview.detail

class DetailPresenter(
    fragment: DetailFragment
) : DetailContract.Presenter {

    private val router: DetailContract.Router = DetailRouter(fragment)
    private var view: DetailContract.View? = null

    override fun bindView(view: DetailContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onBackClicked() {
        router.finish()
    }
}