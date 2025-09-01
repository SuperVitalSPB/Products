package com.supervital.productsdbcompose.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {
    @Insert
    suspend fun insertProduct(product: ProductEntry)

    @Query("SELECT * FROM products")
    fun getAllProducts() : Flow<List<ProductEntry>>
}