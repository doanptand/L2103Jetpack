package com.ddona.jetpack.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ddona.jetpack.model.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Query("DELETE FROM student WHERE _id =:id")
    fun deleteStudentById(id: Int)

    @Query("DELETE FROM student")
    fun deleteAllStudents()

    @Query("SELECT * FROM student")
    fun getAllStudents(): List<Student>

    @Query("SELECT * FROM student")
    fun getAllStudentsWithLiveData(): LiveData<List<Student>>

    @Query("SELECT * FROM student")
    fun getAllStudentsWithFlow(): Flow<List<Student>>

}