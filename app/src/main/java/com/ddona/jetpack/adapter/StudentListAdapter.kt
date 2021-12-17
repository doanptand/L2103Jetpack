package com.ddona.jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddona.jetpack.adapter.diff.StudentItemCallback
import com.ddona.jetpack.databinding.ItemStudentBinding
import com.ddona.jetpack.model.Student


class StudentListAdapter :
    ListAdapter<Student, StudentListAdapter.ViewHolder>(StudentItemCallback) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }

    class ViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
//            binding.tvStudent.text = student.toString()
            binding.s = student
//            Glide.with(binding.root)
//                .load(student.className)
//                .into(binding.imgAvatar)
            binding.executePendingBindings()
        }
    }
}