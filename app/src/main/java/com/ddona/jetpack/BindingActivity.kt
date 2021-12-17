package com.ddona.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddona.jetpack.databinding.ActivityBindingBinding

class BindingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.name = "Trung Doan"
        binding.lifecycleOwner = this
    }
}