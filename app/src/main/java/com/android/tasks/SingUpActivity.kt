package com.android.tasks

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.tasks.dataDAO.UserDAO
import com.android.tasks.dataImpl.UserDAOImpl
import com.android.tasks.dataVO.User

class SingUpActivity : AppCompatActivity() {
    private lateinit var nameUserTextView: EditText
    private lateinit var passwordUserTextView: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var saveButton: Button
    private lateinit var userDAO: UserDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)
        initComponents()
        userDAO = UserDAOImpl(this)
        saveButton.setOnClickListener {
            if (nameUserTextView.text.toString()
                    .isNotEmpty() && passwordUserTextView.text.toString()
                    .isNotEmpty() && passwordUserTextView.text.toString() == confirmPassword.text.toString()
            ) {
                val nameUser: String = nameUserTextView.text.toString()
                val passwordUser: String = passwordUserTextView.text.toString()
                val user = User(userName = nameUser, password = passwordUser)
                val userID = userDAO.addUser(user)
                userDAO = UserDAOImpl(this)
                if (userID > 0) {
                    Toast.makeText(this, getString(R.string.added_user), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, getString(R.string.error_adding_user), Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(this, getString(R.string.fill_out_fields), Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun initComponents() {
        nameUserTextView = findViewById(R.id.user_name_text_view)
        passwordUserTextView = findViewById(R.id.password_user_text_view)
        confirmPassword = findViewById(R.id.confirm_password_user_text_view)
        saveButton = findViewById(R.id.save_button)
    }
}