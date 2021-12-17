package com.ddona.jetpack.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddona.jetpack.db.StudentDatabase
import com.ddona.jetpack.model.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : ViewModel() {

    private val studentDao = StudentDatabase.getInstance(application).getStudentDao()
    val students = studentDao.getAllStudentsWithLiveData()

    fun addStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentDao.insertStudent(student)
        }
    }

    fun deleteStudent(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            studentDao.deleteStudentById(id)
        }
    }

    fun updateStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentDao.updateStudent(student)
        }
    }

}