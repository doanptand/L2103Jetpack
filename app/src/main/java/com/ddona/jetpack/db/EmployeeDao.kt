package com.ddona.jetpack.db

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ddona.jetpack.model.Employee

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employee: Employee)

    @Query("SELECT * FROM employee")
    fun getAllEmployee(): LiveData<List<Employee>>

    @Query("SELECT * FROM employee")
    fun getEmployeeWithPaging(): PagingSource<Int, Employee>
}