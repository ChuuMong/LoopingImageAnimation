package com.chuumong.loopingimage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chuumong.loopingimage.databinding.HolderLoopBinding


class LoopAdapter : ListAdapter<Int, LoopAdapter.LoopViewHolder>(diff) {

    companion object {
        private val diff = object : DiffUtil.ItemCallback<Int>() {
            override fun areItemsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Int, newItem: Int) = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoopViewHolder {
        return LoopViewHolder(
            HolderLoopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LoopViewHolder, position: Int) {
        holder.binding.apply {
            resource = getItem(position)
            executePendingBindings()
        }
    }

    inner class LoopViewHolder(val binding: HolderLoopBinding) : RecyclerView.ViewHolder(binding.root)
}