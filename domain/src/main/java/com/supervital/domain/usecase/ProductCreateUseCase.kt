package com.supervital.domain.usecase

import com.supervital.domain.models.ProductInfo
import com.supervital.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductCreateUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(productInfo: ProductInfo)
        = productsRepository.insertProduct(productInfo)
}