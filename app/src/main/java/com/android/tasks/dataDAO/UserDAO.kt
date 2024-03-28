package com.android.tasks.dataDAO

import com.android.tasks.dataVO.User

interface UserDAO {
    fun addUser(user: User): Long
    fun selectUser(user: User): User?
    fun validateUser(username: String, password: String): Boolean
}