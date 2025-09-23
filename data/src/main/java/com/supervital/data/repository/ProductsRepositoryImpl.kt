package com.supervital.data.repository

import com.supervital.data.database.dao.ProductsDao
import com.supervital.data.mappers.map
import com.supervital.domain.models.ProductInfo
import com.supervital.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsDao: ProductsDao
): ProductsRepository {

    override suspend fun insertProduct(product: ProductInfo) {
        productsDao.insertProduct(product.map())
    }

    override fun getAllProducts(): Flow<List<ProductInfo>> {
        return productsDao.getAllProducts().map {
            it.map {
                it.map()
            }
        }
    }
}