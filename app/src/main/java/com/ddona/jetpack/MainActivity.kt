package com.ddona.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ddona.jetpack.databinding.ActivityMainBinding
import com.ddona.jetpack.vm.MainViewModel
import com.ddona.jetpack.vm.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.btnUp.setOnClickListener {
            viewModel.increaseNumber()
        }
        viewModel.number.observe(this, {
            binding.tvNumber.text = it.toString()
        })
    }
}