package com.example.demoviperbindview.main

import androidx.fragment.app.commit
import com.example.demoviperbindview.R
import com.example.demoviperbindview.detail.DetailFragment

class MainRouter(private val activity: MainFragment) : MainContract.Router {

    private val navController by lazy { activity.requireActivity().supportFragmentManager }

    override fun finish() {
        navController.popBackStack()
    }

    override fun openDetailActivity() {
        navController.commit {
            addToBackStack(null)
            replace(R.id.container, DetailFragment())
        }
    }
}