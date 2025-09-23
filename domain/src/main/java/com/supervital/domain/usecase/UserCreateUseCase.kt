package com.supervital.domain.usecase

import com.supervital.domain.models.UserInfo
import com.supervital.domain.repository.UsersRepository
import javax.inject.Inject

class UserCreateUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    operator fun invoke(userInfo: UserInfo)
        = usersRepository.addUser(userInfo = userInfo)
}