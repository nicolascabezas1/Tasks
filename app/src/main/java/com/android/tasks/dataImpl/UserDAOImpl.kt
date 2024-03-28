package com.android.tasks.dataImpl

import android.content.ContentValues
import android.content.Context
import com.android.tasks.dataBase.DatabaseHelper
import com.android.tasks.dataDAO.UserDAO
import com.android.tasks.dataVO.User

class UserDAOImpl(context: Context) : UserDAO {
    private val dbHelper = DatabaseHelper(context)

    override fun addUser(user: User): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues()
        values.put(DatabaseHelper.KEY_USERNAME, user.userName)
        values.put(DatabaseHelper.KEY_PASSWORD, user.password)
        val success = db.insert(DatabaseHelper.TABLE_USERS, null, values)
        db.close()
        return success
    }
}