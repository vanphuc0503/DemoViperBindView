package com.example.demoviperbindview.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindAdapter {

    @JvmStatic
    @BindingAdapter("app:loadImage")
    fun ImageView.loadImage(url: String? = null) {
        Glide.with(this).load(url).into(this)
    }
}