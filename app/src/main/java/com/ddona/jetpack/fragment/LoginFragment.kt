package com.ddona.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ddona.jetpack.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        binding.btnLogin.setOnClickListener {
            val username = binding.edtAccount.text.toString()
            val password = binding.edtPassword.text.toString()
            val action = LoginFragmentDirections
                .actionLoginFragmentToWelcomeFragment(username, password)
            findNavController().navigate(action)
        }
        return binding.root
    }
}