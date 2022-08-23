package com.cryptsproject.publicservice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cryptsproject.publicservice.R
import com.cryptsproject.publicservice.databinding.FragmentLoginBinding
import com.cryptsproject.publicservice.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    var namestring = FirebaseAuth.getInstance().currentUser?.displayName
    var email = FirebaseAuth.getInstance().currentUser?.email

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNamaLengkap.text = namestring.toString()
        binding.tvEmail.text = email.toString()

        binding.linearTentangAplikasi.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_tentangAplikasiFragment)
        }

        binding.tvKeluar.setOnClickListener {
            signoutUser()
        }

        binding.icEditProfile.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }

    }

    private fun signoutUser(){
        FirebaseAuth.getInstance().signOut()
        findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}