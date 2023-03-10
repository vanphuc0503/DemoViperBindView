package com.example.demoviperbindview.presentation.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

abstract class BaseActivity<DB : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    @get:LayoutRes
    abstract val layoutID: Int

    @get:LayoutRes
    abstract val containerID: Int?

    lateinit var binding: DB

    val navController: NavController?
        @SuppressLint("ResourceType")
        get() {
            containerID?.let { layout ->
                val navHostFragment =
                    supportFragmentManager.findFragmentById(layout) as? NavHostFragment
                return navHostFragment?.navController
            } ?: kotlin.run {
                return null
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (::binding.isInitialized.not()) {
            binding = DataBindingUtil.setContentView(this, layoutID)
        }
    }
}