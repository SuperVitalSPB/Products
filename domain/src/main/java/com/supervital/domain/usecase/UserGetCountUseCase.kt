package com.supervital.domain.usecase

import com.supervital.domain.repository.UsersRepository
import javax.inject.Inject

class UserGetCountUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    operator fun invoke(userName: String)
        = usersRepository.getCountUsers(userName = userName)
}