package com.supervital.domain.di

import com.supervital.domain.repository.RepositoryProduct
import com.supervital.domain.usecase.ProductCreateUseCase
import com.supervital.domain.usecase.ProductGetListUseCase
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
    fun provideProductGetListUseCase(repositoryProduct: RepositoryProduct) =
        ProductGetListUseCase(repositoryProduct)

    @Provides
    @ViewModelScoped
    fun provideProductCreateUseCase(repositoryProduct: RepositoryProduct) =
        ProductCreateUseCase(repositoryProduct)
}