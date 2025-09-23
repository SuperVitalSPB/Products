package com.supervital.domain.di

import com.supervital.domain.repository.ProductsRepository
import com.supervital.domain.repository.UsersRepository
import com.supervital.domain.usecase.ProductCreateUseCase
import com.supervital.domain.usecase.ProductsGetListUseCase
import com.supervital.domain.usecase.UserCreateUseCase
import com.supervital.domain.usecase.UserDeleteUseCase
import com.supervital.domain.usecase.UserGetCountUseCase
import com.supervital.domain.usecase.UsersGetListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ModuleUseCase {

    @Provides
    @ViewModelScoped
    fun provideProductGetListUseCase(productsRepository: ProductsRepository) =
        ProductsGetListUseCase(productsRepository)

    @Provides
    @ViewModelScoped
    fun provideProductCreateUseCase(productsRepository: ProductsRepository) =
        ProductCreateUseCase(productsRepository)

    @Provides
    @ViewModelScoped
    fun provideUserCreateUseCase(usersRepository: UsersRepository) =
        UserCreateUseCase(usersRepository = usersRepository)

    @Provides
    @ViewModelScoped
    fun provideUserDeleteUseCase(usersRepository: UsersRepository) =
        UserDeleteUseCase(usersRepository = usersRepository)

    @Provides
    @ViewModelScoped
    fun provideUserGetCountUseCase(usersRepository: UsersRepository) =
        UserGetCountUseCase(usersRepository = usersRepository)

    @Provides
    @ViewModelScoped
    fun provideUserGetListUseCase(usersRepository: UsersRepository) =
        UsersGetListUseCase(usersRepository = usersRepository)
}