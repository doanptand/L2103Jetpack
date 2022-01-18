package com.ddona.jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.ddona.jetpack.base.BaseActivity
import com.ddona.jetpack.databinding.ActivityMainBinding
import com.ddona.jetpack.vm.MainViewModel
import com.ddona.jetpack.vm.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(application)
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        viewModel =
//            ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]

        binding.btnUp.setOnClickListener {
            viewModel.increaseNumber()
        }
        viewModel.number.observe(this, {
            binding.tvNumber.text = it.toString()
        })

        binding.btnToast.setOnClickListener {
            viewModel.showToast()
        }

        binding.btnNext.setOnClickListener {
            viewModel.nextActivity()
        }

        viewModel.nextActivity.observe(this, {
            if (it) {
                val intent = Intent(this, NavigationActivity::class.java)
                startActivity(intent)
            }
        })

        viewModel.needToast.observe(this, {
            if (it) {
                Toast.makeText(this, "New Toast", Toast.LENGTH_SHORT).show()
            }
        })

        lifecycleScope.launch {
            viewModel.showToastChannel.collect {
                if (it) {
                    Toast.makeText(this@MainActivity, "New Toast", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.navigateToShare.observe(this, {
            it.getContentIfNotHandled()?.let {
                val intent = Intent(this, ShareDataActivity::class.java)
                startActivity(intent)
            }
        })
    }
}