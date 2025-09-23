package com.supervital.data.repository

import com.supervital.data.database.dao.UsersDao
import com.supervital.data.mappers.map
import com.supervital.domain.models.UserInfo
import com.supervital.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Репозиторий содержит код, который вызывает методы DAO для выполнения операций с базой данных.
class UsersRepositoryImpl(
    private val usersDao : UsersDao
): UsersRepository {

    override fun getUsers(): Flow<List<UserInfo>> {
        return usersDao.getUsers().map {
            it.map {
                it.map()
            }
        }
    }

    override fun getCountUsers(userName: String) =
        usersDao.getCountUsers(userName = userName)[0]


    override fun addUser(userInfo: UserInfo) {
        usersDao.addUser(user = userInfo.map())
    }

    override fun deleteUser(user_id: Int) {
        usersDao.deleteUser(user_id = user_id)
    }

}