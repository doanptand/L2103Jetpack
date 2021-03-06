package com.ddona.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.jetpack.adapter.PassengerAdapter
import com.ddona.jetpack.adapter.PassengersLoadStateAdapter
import com.ddona.jetpack.databinding.ActivityPassengerBinding
import com.ddona.jetpack.vm.PassengerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class PassengerActivity : AppCompatActivity() {
    @Inject
    lateinit var adapter: PassengerAdapter
    private lateinit var binding: ActivityPassengerBinding
    private val viewModel: PassengerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPassengerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            header = PassengersLoadStateAdapter { adapter.retry() },
            footer = PassengersLoadStateAdapter { adapter.retry() }
        )
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        lifecycleScope.launchWhenStarted {
            viewModel.passengers.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}