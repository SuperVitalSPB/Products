package com.supervital.data.mappers

import com.supervital.data.database.entries.ProductEntry
import com.supervital.domain.models.ProductInfo

const val BAD_ID = -1

fun ProductEntry.map(): ProductInfo {
    val id = this.id ?: BAD_ID
    return ProductInfo(
        id = id,
        name = this.name,
        numberQR = this.numberQR
    )
}

fun ProductInfo.map() = ProductEntry(
    id = this.id.takeUnless { it == BAD_ID },
    name = this.name,
    numberQR = this.numberQR
)