package com.ddona.jetpack.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddona.jetpack.db.StudentDao
import com.ddona.jetpack.model.Student
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(val studentDao: StudentDao) : ViewModel() {

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