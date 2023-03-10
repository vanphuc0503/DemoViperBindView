package com.example.demoviperbindview.presentation.ui.main.fragment.main

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.demoviperbindview.R
import com.example.demoviperbindview.databinding.FragmentMainBinding
import com.example.demoviperbindview.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainPresenter>() {

    override val layoutID = R.layout.fragment_main

    override val viewModel: MainPresenter by viewModels()

    override fun initCreate() {
        super.initCreate()
        viewModel.apply {
            setRouter(findNavController())
            onCreate()
        }
    }

    override fun initViewCreated() {
        super.initViewCreated()
        binding.btnNext.setOnClickListener {
            viewModel.onItemClicked(MainFragmentDirections.openDetailScreen())
        }
        viewModel.onViewCreated()
        observedData()
    }

    private fun observedData() {
        viewModel.data.observe(viewLifecycleOwner) {
            binding.count = it
        }
    }
}