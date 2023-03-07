package com.example.demoviperbindview.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.demoviperbindview.R
import com.example.demoviperbindview.databinding.FragmentDetailBinding

class DetailFragment : Fragment(), DetailContract.View {

    lateinit var binding: FragmentDetailBinding

    private var presenter: DetailPresenter = DetailPresenter(this)

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
        presenter.bindView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }


    private fun initView() {
        binding.tvScreen.setOnClickListener {
            presenter.onBackClicked()
        }
    }
}
