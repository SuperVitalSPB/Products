package com.supervital.domain.usecase

import com.supervital.domain.repository.RepositoryProduct
import javax.inject.Inject

class ProductGetListUseCase @Inject constructor(
    private val repositoryProduct: RepositoryProduct
) {
    fun getAllProducts() = repositoryProduct.getAllProducts()
}