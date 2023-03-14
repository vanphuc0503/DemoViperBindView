package com.example.demoviperbindview.presentation.ui.main.fragment.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.example.demoviperbindview.data.model.Crew
import com.example.demoviperbindview.data.network.NetworkResponse
import com.example.demoviperbindview.presentation.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPresenter @Inject constructor(
    private val mainInteractor: MainContract.Interactor
) : BaseViewModel(), MainContract.Presenter {

    private var router: MainContract.Router? = null

    private val _data = MutableLiveData<List<Crew>>()
    val data: LiveData<List<Crew>> = _data

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
        callApiResult(call = { mainInteractor.getCrews() }, true) {
            when (val response = it) {
                response as NetworkResponse.Success -> {
                    _data.postValue(response.body)
                }
                else -> {}
            }
        }
    }
}