package com.supervital.domain.usecase

import com.supervital.domain.repository.UsersRepository
import javax.inject.Inject

class UsersGetListUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    operator fun invoke() = usersRepository.getUsers()
}