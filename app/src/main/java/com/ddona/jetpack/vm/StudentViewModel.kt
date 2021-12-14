package com.ddona.jetpack.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import com.ddona.jetpack.db.StudentDatabase
import com.ddona.jetpack.model.Student

class StudentViewModel(application: Application) : ViewModel() {

    private val studentDao = StudentDatabase.getInstance(application).getStudentDao()
    val students = studentDao.getAllStudentsWithLiveData()

    suspend fun addStudent(student: Student) {
        studentDao.insertStudent(student)
    }

    suspend fun deleteStudent(id: Int) {
        studentDao.deleteStudentById(id)
    }

    suspend fun updateStudent(student: Student) {
        studentDao.updateStudent(student)
    }

}