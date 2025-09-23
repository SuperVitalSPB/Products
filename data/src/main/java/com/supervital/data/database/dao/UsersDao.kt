package com.supervital.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.supervital.data.database.entries.UserEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<UserEntry>>

    @Query("SELECT count(*) FROM users WHERE user_name = :userName")
    fun getCountUsers(userName: String): List<Int>

    @Insert
    fun addUser(user: UserEntry)

    @Query("DELETE FROM users WHERE user_id = :user_id")
    fun deleteUser(user_id: Int)
}