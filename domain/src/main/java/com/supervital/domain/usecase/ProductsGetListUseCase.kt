package com.supervital.domain.usecase

import com.supervital.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsGetListUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    operator fun invoke() = productsRepository.getAllProducts()
}