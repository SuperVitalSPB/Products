package com.supervital.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.supervital.data.database.dao.ProductsDao
import com.supervital.data.database.dao.UsersDao
import com.supervital.data.database.entries.ProductEntry
import com.supervital.data.database.entries.UserEntry

@Database(entities = [ProductEntry::class, UserEntry::class], version = 1)
abstract class StorageDb : RoomDatabase() {
    abstract val productsDao: ProductsDao
    abstract val userDao: UsersDao
}


