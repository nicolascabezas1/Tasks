package com.android.tasks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var buttonLogIn : Button
    private lateinit var buttonSignUp : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        buttonSignUp.setOnClickListener{
            intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initComponents() {
        buttonLogIn = findViewById(R.id.log_in_button)
        buttonSignUp = findViewById(R.id.sign_up_button)
    }
}