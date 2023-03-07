package com.example.demoviperbindview.main

import com.example.demoviperbindview.base.BasePresenter

class MainPresenter(
    fragment: MainFragment
) : BasePresenter(), MainContract.Presenter {

    private val router: MainContract.Router = MainRouter(fragment)
    private val mainInteractor: MainInteractor = MainInteractor()

    private var view: MainContract.View? = null

    override fun bindView(view: MainContract.View) {
        this.view = view.apply {

        }
    }

    override fun unbindView() {
        view = null
    }

    override fun onBackClicked() {
        router.finish()
    }

    override fun onItemClicked() {
        router.openDetailActivity()
    }

    override fun onViewCreated() {

    }

    override fun onCreate() {
        mainInteractor.getData({
//            checkExistedView(view, {
//
//            }) {
//                showData(it)
//            }
            view!!.showData(it)
        }, ::onError)
    }

    private fun onError(error: Throwable) {
        view!!.showData(error.message.toString())
    }
}