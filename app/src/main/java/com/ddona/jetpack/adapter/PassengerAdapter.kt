package com.ddona.jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ddona.jetpack.databinding.ItemPassengerBinding
import com.ddona.jetpack.model.Passenger

class PassengerAdapter :
    PagingDataAdapter<Passenger, PassengerAdapter.ViewHolder>(PassengerComparator) {
    object PassengerComparator : DiffUtil.ItemCallback<Passenger>() {
        override fun areItemsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(private val binding: ItemPassengerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(passenger: Passenger) {
            binding.passenger = passenger
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPassengerBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }
}