package com.example.demoviperbindview.presentation.ui.home

import com.example.demoviperbindview.R
import com.example.demoviperbindview.databinding.ActivityHomeBinding
import com.example.demoviperbindview.presentation.ui.base.BaseActivity
import com.example.demoviperbindview.presentation.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, BaseViewModel>() {

    override val layoutID = R.layout.activity_home
    override val containerID: Int = R.id.homeContainer
}