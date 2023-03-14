package com.example.demoviperbindview.presentation.ui.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demoviperbindview.BR
import javax.annotation.Nonnull

class BaseListAdapterRecyclerview<T : Any>(
    @LayoutRes private val layoutItem: Int
) : ListAdapter<T, BaseListAdapterRecyclerview.ViewHolder>(object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(@Nonnull oldItem: T, @Nonnull newItem: T): Boolean {
        return oldItem === newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(@Nonnull oldItem: T, @Nonnull newItem: T): Boolean {
        return oldItem == newItem
    }
}) {

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
            setVariable(BR.item, currentList[position])
            setVariable(BR.isLastLine, currentList.lastIndex == position)
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int = currentList.size

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}