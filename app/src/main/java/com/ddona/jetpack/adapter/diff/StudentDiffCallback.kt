package com.ddona.jetpack.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.ddona.jetpack.model.Student

class StudentDiffCallback(
    private val oldItems: List<Student>,
    private val newItems: List<Student>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }


}