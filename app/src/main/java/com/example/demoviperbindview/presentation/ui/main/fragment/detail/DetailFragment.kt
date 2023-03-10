package com.example.demoviperbindview.presentation.ui.main.fragment.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.demoviperbindview.R
import com.example.demoviperbindview.databinding.FragmentDetailBinding
import com.example.demoviperbindview.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailPresenter>() {

    override val layoutID = R.layout.fragment_detail

    override val viewModel: DetailPresenter by viewModels()

    override fun initCreate() {
        super.initCreate()
        viewModel.apply {
            setRouter(findNavController())
        }
    }

    override fun initViewCreated() {
        super.initViewCreated()
        binding.apply {
            tvScreen.setOnClickListener {
                viewModel.onBackClicked()
            }
            btnHome.setOnClickListener {
                viewModel.onOpenHome(DetailFragmentDirections.openHomeActivity())
            }
        }
    }
}
