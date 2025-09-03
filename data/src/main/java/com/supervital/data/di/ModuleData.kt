package com.supervital.data.di

import com.supervital.data.database.dao.ProductsDao
import com.supervital.data.repository.RepositoryProductImpl
import com.supervital.domain.repository.RepositoryProduct
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
    fun provideRepositoryProduct(productsDao: ProductsDao): RepositoryProduct =
        RepositoryProductImpl(productsDao = productsDao)
}