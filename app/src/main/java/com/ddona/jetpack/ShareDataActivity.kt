package com.ddona.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddona.jetpack.adapter.MusicPagerAdapter
import com.ddona.jetpack.databinding.ActivityShareDataBinding
import com.google.android.material.tabs.TabLayoutMediator

class ShareDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShareDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = MusicPagerAdapter(this)
        binding.vpMusic.adapter = adapter
        val titles = arrayOf("Song", "Album")
        TabLayoutMediator(binding.tbMusic, binding.vpMusic) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}