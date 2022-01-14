package com.ddona.jetpack.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.ddona.jetpack.db.EmployeeDatabase
import com.ddona.jetpack.model.Employee
import kotlinx.coroutines.launch

class EmployeeViewModel(
    private val app: Application
) : ViewModel() {
    private val employeeDao = EmployeeDatabase
        .getInstance(app.applicationContext, viewModelScope)
        .employeeDao()

    val employees = employeeDao.getAllEmployee()

    val employeePager = Pager(
        PagingConfig(pageSize = 20)
    ) {
        employeeDao.getEmployeeWithPaging()
    }.flow.cachedIn(viewModelScope)

    fun insertEmployee(employee: Employee) {
        viewModelScope.launch {
            employeeDao.insert(employee)
        }
    }
}