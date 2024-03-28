package com.android.tasks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.tasks.dataDAO.UserDAO
import com.android.tasks.dataImpl.UserDAOImpl

class MainActivity : AppCompatActivity() {
    private lateinit var buttonLogIn: Button
    private lateinit var buttonSignUp: Button
    private lateinit var nameUser: EditText
    private lateinit var passwordUser: EditText
    private lateinit var userDAO: UserDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        userDAO = UserDAOImpl(this)
        buttonSignUp.setOnClickListener {
            intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }
        buttonLogIn.setOnClickListener{
            val userName = nameUser.text.toString()
            val passwordName = passwordUser.text.toString()
            if (userDAO.validateUser(userName, passwordName)){
                val intent = Intent(this, PanelActivity::class.java).apply {
                    putExtra("username", userName)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initComponents() {
        buttonLogIn = findViewById(R.id.log_in_button)
        buttonSignUp = findViewById(R.id.sign_up_button)
        nameUser = findViewById(R.id.user_name_text_view)
        passwordUser = findViewById(R.id.password_user_text_view)
    }
}