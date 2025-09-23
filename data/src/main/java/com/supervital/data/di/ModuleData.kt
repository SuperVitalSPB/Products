package com.supervital.data.di

import com.supervital.data.database.dao.ProductsDao
import com.supervital.data.database.dao.UsersDao
import com.supervital.data.repository.ProductsRepositoryImpl
import com.supervital.data.repository.UsersRepositoryImpl
import com.supervital.domain.repository.ProductsRepository
import com.supervital.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleData {

    @Provides
    @Singleton
    fun provideProductRepository(productsDao: ProductsDao): ProductsRepository =
        ProductsRepositoryImpl(productsDao = productsDao)

    @Provides
    @Singleton
    fun provideUserRepository(usersDao: UsersDao): UsersRepository  =
        UsersRepositoryImpl(usersDao = usersDao)
}