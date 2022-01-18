package com.ddona.jetpack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ddona.jetpack.databinding.LayoutLoadingBinding

class PassengersLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<PassengersLoadStateAdapter.ViewHolder>() {
    override fun onBindViewHolder(
        holder: ViewHolder,
        loadState: LoadState
    ) {
        holder.bind(loadState)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): ViewHolder {
        return ViewHolder(
            LayoutLoadingBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    inner class ViewHolder(private val binding: LayoutLoadingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.tvError.visibility = View.VISIBLE
                binding.buttonRetry.visibility = View.VISIBLE
                binding.tvError.text = loadState.error.localizedMessage
            } else {
                binding.buttonRetry.visibility = View.GONE
                binding.tvError.visibility = View.GONE
            }
            if (loadState is LoadState.Loading) {
                binding.progressbar.visibility = View.VISIBLE
            } else {
                binding.progressbar.visibility = View.GONE
            }
            binding.buttonRetry.setOnClickListener {
                retry()
            }
        }
    }
}