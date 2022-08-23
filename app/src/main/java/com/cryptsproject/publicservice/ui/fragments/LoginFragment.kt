package com.cryptsproject.publicservice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.cryptsproject.publicservice.R
import com.cryptsproject.publicservice.databinding.FragmentLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!


    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = Firebase.auth.currentUser
        if (user != null){
            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
        }
//
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(242372969261-jq84ge1vhujfel3oha3io3k50ml8rrec.apps.googleusercontent.com)
//            .requestEmail()
//            .build()
//
//        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.btnLogin.setOnClickListener {
            loginUser()
        }

//        binding.btnLoginGoogle.setOnClickListener {
//
//        }

        binding.tvDaftar2.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loginUser(){
        val email : String = binding.etEmail.text.toString()
        val password :String = binding.etPassword.text.toString()
        if(email.isNullOrEmpty() or password.isNullOrEmpty()){
            Toast.makeText(requireContext(), "Wrong password or email", Toast.LENGTH_LONG).show()
        }else{
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                    }
                }.addOnFailureListener {
                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_LONG).show()
                }
        }



    }

//    private fun loginGoogle(){
//        val signInIntent = googleSignInClient.signInIntent
//        startActivityForResult(signInIntent, RC_SIGN_IN)
}



