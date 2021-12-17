package com.ddona.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ddona.jetpack.adapter.StudentAdapter
import com.ddona.jetpack.databinding.ActivityStudentBinding
import com.ddona.jetpack.model.Student
import com.ddona.jetpack.vm.StudentViewModel
import com.ddona.jetpack.vm.StudentViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentBinding
    private lateinit var adapter: StudentAdapter
    private val students = arrayListOf<Student>()
    private val viewModel: StudentViewModel by viewModels {
        StudentViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = StudentAdapter(students)
        binding.rvStudent.adapter = adapter
        viewModel.students.observe(this, {
            students.clear()
            students.addAll(it)
            adapter.notifyDataSetChanged()
        })
        binding.btnAdd.setOnClickListener {
            val name = binding.edtName.text.toString()
            val age = binding.edtAge.text.toString()
            val className = binding.edtClassName.text.toString()
            viewModel.addStudent(Student(name = name, age = age.toInt(), className = className))
        }
        binding.btnDel.setOnClickListener {
            val id = binding.edtId.text.toString()
            viewModel.deleteStudent(id.toInt())
        }
        binding.btnEdit.setOnClickListener {
            val id = binding.edtId.text.toString()
            val name = binding.edtName.text.toString()
            val age = binding.edtAge.text.toString()
            val className = binding.edtClassName.text.toString()
            viewModel.updateStudent(Student(id.toInt(), name, age.toInt(), className))
        }
    }
}