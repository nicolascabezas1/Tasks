package com.android.tasks

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class PanelActivity : AppCompatActivity() {
    private lateinit var nameUser: TextView
    private lateinit var taskRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)
        initComponents()
        val userName = intent.getStringExtra("username")
        nameUser.text = buildString {
            append(getString(R.string.welcome))
            append(" ")
            append(userName)
        }
    }

    private fun initComponents() {
        nameUser = findViewById(R.id.name_user_title)
        taskRecyclerView = findViewById(R.id.task_recycler_view)
    }
}