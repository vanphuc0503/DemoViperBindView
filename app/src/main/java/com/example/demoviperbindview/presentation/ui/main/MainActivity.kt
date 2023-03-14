package com.example.demoviperbindview.presentation.ui.main

import com.example.demoviperbindview.R
import com.example.demoviperbindview.databinding.ActivityMainBinding
import com.example.demoviperbindview.presentation.ui.base.BaseActivity
import com.example.demoviperbindview.presentation.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {

    override val layoutID = R.layout.activity_main
    override val containerID: Int = R.id.mainContainer
}