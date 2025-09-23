package com.supervital.domain.usecase

import com.supervital.domain.repository.UsersRepository
import javax.inject.Inject

class UserDeleteUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    operator fun invoke(user_id: Int)
        = usersRepository.deleteUser(user_id = user_id)
}