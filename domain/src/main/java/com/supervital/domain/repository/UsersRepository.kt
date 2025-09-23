package com.supervital.domain.repository

import com.supervital.domain.models.UserInfo
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    fun getUsers(): Flow<List<UserInfo>>

    fun getCountUsers(userName: String): Int

    fun addUser(userInfo: UserInfo)

    fun deleteUser(user_id: Int)

}