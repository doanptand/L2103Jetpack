package com.ddona.jetpack.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.ddona.jetpack.model.Student

object StudentItemCallback : DiffUtil.ItemCallback<Student>() {
    override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
        return oldItem == newItem
    }
}