package com.ddona.jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ddona.jetpack.databinding.ItemEmployeeBinding
import com.ddona.jetpack.model.Employee

class EmployeePagerAdapter :
    PagingDataAdapter<Employee, EmployeePagerAdapter.ViewHolder>(EmployeeComparator) {

    object EmployeeComparator : DiffUtil.ItemCallback<Employee>() {
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem == newItem
        }

    }


    class ViewHolder(private val binding: ItemEmployeeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindEmployee(employee: Employee) {
            binding.employee = employee
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bindEmployee(it)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(ItemEmployeeBinding.inflate(LayoutInflater.from(parent.context)))
    }
}