package com.example.demoviperbindview.presentation.ui.home.fragment.user

import androidx.fragment.app.viewModels
import com.example.demoviperbindview.R
import com.example.demoviperbindview.databinding.FragmentUserBinding
import com.example.demoviperbindview.presentation.ui.base.BaseFragment
import com.example.demoviperbindview.presentation.ui.base.BaseViewModel

class UserFragment : BaseFragment<FragmentUserBinding, BaseViewModel>() {

    override val layoutID = R.layout.fragment_user
    override val viewModel: BaseViewModel by viewModels()
}