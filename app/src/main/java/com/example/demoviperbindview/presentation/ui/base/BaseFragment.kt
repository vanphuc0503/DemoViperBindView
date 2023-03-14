package com.example.demoviperbindview.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<DB : ViewDataBinding, VM : ViewModel> : Fragment() {

    @get:LayoutRes
    abstract val layoutID: Int

    lateinit var binding: DB

    abstract val viewModel: VM?

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        if (!::binding.isInitialized) {
            val baseInflater = LayoutInflater.from(requireActivity())
            binding =
                DataBindingUtil.inflate(baseInflater, layoutID, container, false)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initCreate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewCreated()
        initObserved()
    }

    open fun initCreate() {}
    open fun initViewCreated() {}

    open fun initObserved() {}
}