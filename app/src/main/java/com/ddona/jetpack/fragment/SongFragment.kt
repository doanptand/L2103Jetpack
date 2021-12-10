package com.ddona.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ddona.jetpack.databinding.FragmentSongBinding
import com.ddona.jetpack.vm.MusicViewModel

class SongFragment : Fragment() {
    private lateinit var binding: FragmentSongBinding
    private lateinit var viewModel: MusicViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //activity
        //application context
        binding = FragmentSongBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[MusicViewModel::class.java]
        viewModel.number.observe(viewLifecycleOwner, {
            binding.tvNumber.text = it.toString()
        })
        binding.btnUp.setOnClickListener {
            viewModel.increaseNumber()
        }
        return binding.root
    }
}