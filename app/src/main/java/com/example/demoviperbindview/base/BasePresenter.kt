package com.example.demoviperbindview.base

abstract class BasePresenter {

    open val initData = mutableListOf<Any>()

    open fun <T> checkExistedView(view: T?, notExisted: () -> Unit, existed: T.() -> Unit) {
        if (view == null) {
            notExisted.invoke()
        } else {
            existed.invoke(view)
        }
    }
}