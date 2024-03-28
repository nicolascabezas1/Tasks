package com.android.tasks.dataDAO

import com.android.tasks.dataVO.User

interface UserDAO {
    fun addUser(user: User): Long
}