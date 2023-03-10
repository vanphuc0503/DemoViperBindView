package com.example.demoviperbindview.presentation.ui.home.fragment.home

import androidx.fragment.app.viewModels
import com.example.demoviperbindview.R
import com.example.demoviperbindview.databinding.FragmentHomeBinding
import com.example.demoviperbindview.presentation.base.BaseFragment
import com.example.demoviperbindview.presentation.base.BaseViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, BaseViewModel>() {

    override val layoutID = R.layout.fragment_home
    override val viewModel: BaseViewModel by viewModels()
}