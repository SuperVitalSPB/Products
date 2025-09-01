package com.supervital.productsdbcompose.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntry::class], version = 1)
abstract class MainDb : RoomDatabase() {
    abstract val dao: ProductsDao
}