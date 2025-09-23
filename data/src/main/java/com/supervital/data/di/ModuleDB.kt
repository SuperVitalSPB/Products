package com.supervital.data.di

import android.app.Application
import androidx.room.Room
import com.supervital.data.database.StorageDb
import com.supervital.data.database.dao.ProductsDao
import com.supervital.data.database.dao.UsersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleDB {

    @Provides
    @Singleton
    fun provideStorageDb(app: Application) : StorageDb {
        return Room.databaseBuilder(
            app,
            StorageDb::class.java,
            "storage.db"
        ).build()
    }

    @Provides
    fun provideProductsDao(storageDb: StorageDb) : ProductsDao = storageDb.productsDao

    @Provides
    fun provideUsersDao(storageDb: StorageDb) : UsersDao = storageDb.userDao
}