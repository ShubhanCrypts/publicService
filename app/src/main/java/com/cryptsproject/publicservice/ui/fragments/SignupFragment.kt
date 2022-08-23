package com.cryptsproject.publicservice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.cryptsproject.publicservice.R
import com.cryptsproject.publicservice.databinding.FragmentSignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.math.sign

class SignupFragment : Fragment(R.layout.fragment_signup) {

    private var _binding: FragmentSignupBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val user =Firebase.auth.currentUser

        binding.btnDaftar.setOnClickListener {
            signupUser()
//            if (user != null){
//                findNavController().navigate(R.id.action_signupFragment2_to_dashboardFragment)
//            }
        }

    }

    private fun signupUser(){
        val email: String = binding.etEmail.text.toString()
        val password: String = binding.etPassword.text.toString()
        if(email.isNullOrEmpty() or password.isNullOrEmpty()){
            Toast.makeText(requireContext(), "Please enter email and password", Toast.LENGTH_LONG).show()
        }else{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        findNavController().navigate(R.id.action_signupFragment_to_dashboardFragment)
                    }else{
//                        Toast.makeText(requireContext(), it.result., Toast.LENGTH_LONG).show()

                    }
                }.addOnFailureListener {
                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_LONG).show()
                }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}