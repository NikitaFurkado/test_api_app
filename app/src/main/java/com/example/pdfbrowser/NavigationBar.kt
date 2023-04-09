package com.example.pdfbrowser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pdfbrowser.R
import com.example.pdfbrowser.fragment.HomeFragment
import com.example.pdfbrowser.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationBar : AppCompatActivity() {

    //private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_bar)

        loadFragment(HomeFragment())

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavBar)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> loadFragment(homeFragment)
                R.id.profile -> loadFragment(profileFragment)
            }
            true
        }
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout, fragment)
        transaction.commit()
    }
}