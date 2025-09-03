package com.supervital.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.supervital.data.database.dao.ProductsDao
import com.supervital.data.database.entries.ProductEntry

@Database(entities = [ProductEntry::class], version = 1)
abstract class ProductsDb : RoomDatabase() {
    abstract val dao: ProductsDao
}