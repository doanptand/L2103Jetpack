package com.ddona.jetpack.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ddona.jetpack.fragment.AlbumFragment
import com.ddona.jetpack.fragment.SongFragment
import java.lang.IllegalArgumentException

class MusicPagerAdapter(private val activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SongFragment()
            1 -> AlbumFragment()
            else -> throw IllegalArgumentException("Unknown fragment for $position")
        }
    }
}