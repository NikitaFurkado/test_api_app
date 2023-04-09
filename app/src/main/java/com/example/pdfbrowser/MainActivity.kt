package com.example.pdfbrowser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBtn = findViewById<Button>(R.id.btn)

        btnBtn.setOnClickListener {
            val intent = Intent(this, NavigationBar::class.java)
            startActivity(intent)
        }
    }
}