package com.example.demoviperbindview.presentation.ui.main.fragment.main

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainInteractor() : MainContract.Interactor {

    override fun getData(onSuccess: (String) -> Unit, onError: (Throwable) -> Unit) {
        GlobalScope.launch {
            runCatching {
                delay(5000)
            }.onSuccess {
                onSuccess("Thanh cong")
            }.onFailure {
                onError(Throwable("Error"))
            }
        }
    }

}