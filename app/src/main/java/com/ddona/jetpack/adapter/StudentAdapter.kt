package com.ddona.jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ddona.jetpack.adapter.diff.StudentDiffCallback
import com.ddona.jetpack.databinding.ActivityMainBinding
import com.ddona.jetpack.databinding.ItemStudentBinding
import com.ddona.jetpack.model.Student

class StudentAdapter :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    private val students = arrayListOf<Student>()

    fun submit(items: List<Student>) {
        val diffCallback = StudentDiffCallback(students, items)
        val diff = DiffUtil.calculateDiff(diffCallback)
        this.students.clear()
        this.students.addAll(items)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int = students.size

    class ViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.tvStudent.text = student.toString()
        }
    }
}