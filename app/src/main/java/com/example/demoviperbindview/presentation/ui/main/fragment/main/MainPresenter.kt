package com.example.demoviperbindview.presentation.ui.main.fragment.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPresenter @Inject constructor(

) : ViewModel(), MainContract.Presenter {

    private var router: MainContract.Router? = null
    private val mainInteractor: MainInteractor = MainInteractor()

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    fun setRouter(controller: NavController) {
        router = MainRouter(controller)
    }

    override fun onBackClicked() {
        router?.finish()
    }

    override fun onItemClicked(action: NavDirections) {
        router?.openDetailActivity(action)
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