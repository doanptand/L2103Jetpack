package com.ddona.jetpack

import android.os.Bundle
import androidx.activity.viewModels
import com.ddona.jetpack.adapter.StudentListAdapter
import com.ddona.jetpack.base.BaseActivity
import com.ddona.jetpack.databinding.ActivityStudentBinding
import com.ddona.jetpack.model.Student
import com.ddona.jetpack.vm.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentActivity : BaseActivity() {
    private lateinit var binding: ActivityStudentBinding

    //    private lateinit var adapter: StudentAdapter
    private lateinit var adapter: StudentListAdapter
    private val viewModel: StudentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        adapter = StudentAdapter()
        adapter = StudentListAdapter()
        binding.rvStudent.adapter = adapter
        viewModel.students.observe(this, {
            adapter.submitList(it)
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