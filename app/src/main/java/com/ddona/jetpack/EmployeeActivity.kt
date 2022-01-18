package com.ddona.jetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.jetpack.adapter.EmployeePagerAdapter
import com.ddona.jetpack.base.BaseActivity
import com.ddona.jetpack.databinding.ActivityEmployeeBinding
import com.ddona.jetpack.vm.EmployeeViewModel
import com.ddona.jetpack.vm.ViewModelProviderFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EmployeeActivity : BaseActivity() {

    private val viewModel: EmployeeViewModel by viewModels {
        ViewModelProviderFactory(application)
    }
    private lateinit var binding: ActivityEmployeeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.employees.observe(this, {
            Log.d("doanpt", "employee size: ${it.size}")
        })

        val employeeAdapter = EmployeePagerAdapter()
        binding.rvEmployee.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvEmployee.adapter = employeeAdapter

        lifecycleScope.launchWhenStarted {
            viewModel.employeePager.collectLatest {
                employeeAdapter.submitData(it)
            }
        }

    }
}