package com.example.demoviperbindview.presentation.ui.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.demoviperbindview.BR

class BaseRecyclerview<T>(
    @LayoutRes private val layoutItem: Int
) : RecyclerView.Adapter<BaseRecyclerview.ViewHolder>() {

    private val data = mutableListOf<T>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<T>) {
        this.data.apply {
            clear()
            addAll(data)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutItem,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            setVariable(BR.item, data[position])
            setVariable(BR.isLastLine, data.lastIndex == position)
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}