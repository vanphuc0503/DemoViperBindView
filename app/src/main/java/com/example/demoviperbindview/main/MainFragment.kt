package com.example.demoviperbindview.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.demoviperbindview.R
import com.example.demoviperbindview.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val presenter: MainPresenter by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        if (!::binding.isInitialized) {
            val baseInflater = LayoutInflater.from(requireActivity())
            binding =
                DataBindingUtil.inflate(baseInflater, R.layout.fragment_main, container, false)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.apply {
            setRouter(this@MainFragment)
            onCreate()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            presenter.onItemClicked()
        }
        presenter.onViewCreated()
        observedData()
    }

    private fun observedData() {
        presenter.data.observe(viewLifecycleOwner) {
            binding.count = it
        }
    }
}