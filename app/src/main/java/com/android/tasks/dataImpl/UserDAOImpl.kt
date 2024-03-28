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

    override fun selectUser(user: User): User? {
        val db = dbHelper.readableDatabase
        val selectedQuery =
            "SELECT * FROM ${DatabaseHelper.TABLE_USERS} WHERE ${DatabaseHelper.KEY_USERNAME} = ?"
        val cursor = db.rawQuery(selectedQuery, arrayOf(user.userName))
        if (cursor?.moveToFirst() == true) {
            val selectedUser = User(
                userName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.KEY_USERNAME)),
                password = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.KEY_PASSWORD))
            )
            cursor.close()
            return selectedUser
        }
        cursor?.close()
        return null
    }

    override fun validateUser(username: String, password: String): Boolean {
        val db = dbHelper.readableDatabase
        val selectQuery =
            "SELECT * FROM ${DatabaseHelper.TABLE_USERS} WHERE ${DatabaseHelper.KEY_USERNAME} = ? AND ${DatabaseHelper.KEY_PASSWORD} = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(username, password))
        val isValid = cursor?.moveToFirst() ?: false
        cursor?.close()
        return isValid
    }
}