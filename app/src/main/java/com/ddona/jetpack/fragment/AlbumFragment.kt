package com.ddona.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ddona.jetpack.databinding.FragmentAlbumBinding
import com.ddona.jetpack.vm.MusicViewModel

class AlbumFragment : Fragment() {
    private lateinit var binding: FragmentAlbumBinding
    private lateinit var viewModel: MusicViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumBinding.inflate(inflater)
//        viewModel = ViewModelProvider(this)[MusicViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity())[MusicViewModel::class.java]
        binding.btnUp.setOnClickListener { viewModel.increaseNumber() }
        viewModel.number.observe(viewLifecycleOwner, {
            binding.tvNumber.text = it.toString()
        })
        return binding.root
    }
}