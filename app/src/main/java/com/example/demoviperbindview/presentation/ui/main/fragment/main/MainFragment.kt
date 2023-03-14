package com.example.demoviperbindview.presentation.ui.main.fragment.main

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.demoviperbindview.R
import com.example.demoviperbindview.data.model.Crew
import com.example.demoviperbindview.databinding.FragmentMainBinding
import com.example.demoviperbindview.presentation.ui.base.BaseFragment
import com.example.demoviperbindview.presentation.ui.base.BaseRecyclerview
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainPresenter>() {

    override val layoutID = R.layout.fragment_main

    override val viewModel: MainPresenter by viewModels()

    private val recyclerCrew by lazy {
        BaseRecyclerview<Crew>(R.layout.item_crew)
    }

    override fun initCreate() {
        super.initCreate()
        viewModel.apply {
            setRouter(findNavController())
            onCreate()
        }
    }

    override fun initViewCreated() {
        super.initViewCreated()
        binding.apply {
            btnNext.setOnClickListener {
                viewModel.onItemClicked(MainFragmentDirections.openDetailScreen())
            }
            recyclerCrews.adapter = recyclerCrew
        }
        viewModel.onViewCreated()
    }

    override fun initObserved() {
        super.initObserved()
        viewModel.apply {
            data.observe(viewLifecycleOwner) {
                recyclerCrew.updateData(it)
            }
            isLoading.observe(viewLifecycleOwner) {
                binding.isLoading = it
            }
        }
    }
}