package com.example.demoviperbindview.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPresenter @Inject constructor() : ViewModel(), MainContract.Presenter {

    private var router: MainContract.Router? = null
    private val mainInteractor: MainInteractor = MainInteractor()

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    fun setRouter(fragment: MainFragment) {
        router = MainRouter(fragment)
    }

    override fun onBackClicked() {
        router?.finish()
    }

    override fun onItemClicked() {
        router?.openDetailActivity()
    }

    override fun onViewCreated() {

    }

    override fun onCreate() {
        mainInteractor.getData({
            _data.postValue(it)
        }, ::onError)
    }

    private fun onError(error: Throwable) {
        _data.postValue(error.message.toString())
    }
}