package com.example.demoviperbindview.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.demoviperbindview.R
import com.example.demoviperbindview.databinding.FragmentDetailBinding
import com.example.demoviperbindview.databinding.FragmentMainBinding
import com.example.demoviperbindview.main.MainPresenter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val presenter: DetailPresenter by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.apply {
            setRouter(this@DetailFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (!::binding.isInitialized) {
            val baseInflater = LayoutInflater.from(requireActivity())
            binding =
                DataBindingUtil.inflate(baseInflater, R.layout.fragment_detail, container, false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView() {
        binding.tvScreen.setOnClickListener {
            presenter.onBackClicked()
        }
    }
}
