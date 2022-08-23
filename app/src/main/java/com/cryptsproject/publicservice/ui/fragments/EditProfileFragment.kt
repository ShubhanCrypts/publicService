package com.cryptsproject.publicservice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cryptsproject.publicservice.R
import com.cryptsproject.publicservice.databinding.FragmentEditProfileBinding
import com.cryptsproject.publicservice.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {

    private var _binding: FragmentEditProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGantiNama.setOnClickListener {
            updateProfile()
        }
    }

    private fun updateProfile(){
        FirebaseAuth.getInstance().currentUser?.let {
            val username = binding.etEditNama.text.toString()
            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(username)
//                .setPhotoUri(profpic)
                .build()
            it.updateProfile(profileUpdates)
        }
        findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment)

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}