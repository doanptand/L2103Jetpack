package com.ddona.jetpack.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ddona.jetpack.model.*
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("DELETE FROM student WHERE id =:id")
    suspend fun deleteStudentById(id: Int)

    @Query("DELETE FROM student")
    suspend fun deleteAllStudents()

    @Query("SELECT * FROM student")
    suspend fun getAllStudents(): List<Student>

    @Query("SELECT * FROM student")
    fun getAllStudentsWithLiveData(): LiveData<List<Student>>

    @Query("SELECT * FROM student")
    fun getAllStudentsWithFlow(): Flow<List<Student>>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :name")
    fun getSchoolAndDirector(name: String): LiveData<List<SchoolAndDirector>>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolName")
    fun getSchoolAndStudents(schoolName: String): LiveData<List<SchoolAndStudents>>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName= :subjectName")
    fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE id= :id")
    fun getSubjectsOfStudent(id: Int): List<StudentWithSubjects>

}