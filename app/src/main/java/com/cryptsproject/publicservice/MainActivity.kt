package com.cryptsproject.publicservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.cryptsproject.publicservice.databinding.FragmentPendaftaranBinding
import com.cryptsproject.publicservice.ui.fragments.PendaftaranFragment
import com.cryptsproject.publicservice.ui.fragments.webViewGlobal
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

//        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        val navController = Navigation.findNavController(this, R.id.activityNavFragment)
        NavigationUI.setupWithNavController(bottomNav, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.loginFragment || destination.id == R.id.signupFragment) {
                bottomNav.visibility = View.GONE
            } else {
                bottomNav.visibility = View.VISIBLE
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        webViewGlobal.onActivityResult(requestCode, resultCode, data)
    }
}