package com.supervital.domain.repository

import com.supervital.domain.models.ProductInfo
import kotlinx.coroutines.flow.Flow

interface RepositoryProduct {

    suspend fun insertProduct(product: ProductInfo)

    fun getAllProducts() : Flow<List<ProductInfo>>
}