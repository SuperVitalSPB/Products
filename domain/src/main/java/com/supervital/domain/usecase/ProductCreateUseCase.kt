package com.supervital.domain.usecase

import com.supervital.domain.models.ProductInfo
import com.supervital.domain.repository.RepositoryProduct
import javax.inject.Inject

class ProductCreateUseCase @Inject constructor(
    private val repositoryProduct: RepositoryProduct
) {
    suspend fun insertProduct(productInfo: ProductInfo)
        = repositoryProduct.insertProduct(productInfo)
}