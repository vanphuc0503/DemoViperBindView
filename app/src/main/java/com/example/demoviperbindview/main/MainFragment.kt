package com.example.demoviperbindview.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.demoviperbindview.R
import com.example.demoviperbindview.databinding.FragmentMainBinding

class MainFragment: Fragment(), MainContract.View {

    private lateinit var binding: FragmentMainBinding

    private val presenter: MainPresenter = MainPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (!::binding.isInitialized) {
            val baseInflater = LayoutInflater.from(requireActivity())
            binding = DataBindingUtil.inflate(baseInflater, R.layout.fragment_main, container, false)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            presenter.onItemClicked()
        }

        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun showData(data: String) {
        binding.count = data
    }
}