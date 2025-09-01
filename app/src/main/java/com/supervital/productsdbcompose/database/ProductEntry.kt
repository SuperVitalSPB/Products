package com.supervital.productsdbcompose.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val numberQR: String
)