package com.supervital.data.mappers

import com.supervital.data.database.entries.ProductEntry
import com.supervital.domain.models.ProductInfo

fun ProductEntry.map(): ProductInfo {
    val id = this.id ?: -1
    return ProductInfo(
        id = id,
        name = this.name,
        numberQR = this.numberQR
    )
}

fun ProductInfo.map() = ProductEntry(
    id = if (this.id == -1) null else this.id,
    name = this.name,
    numberQR = this.numberQR
)