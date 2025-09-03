package com.supervital.data.di

import android.app.Application
import androidx.room.Room
import com.supervital.data.database.ProductsDb
import com.supervital.data.database.dao.ProductsDao
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
    fun provideMainDb(app: Application) : ProductsDb {
        return Room.databaseBuilder(
            app,
            ProductsDb::class.java,
            "products.db"
        ).build()
    }

    @Provides
    fun provideProductDao(productsDb: ProductsDb) : ProductsDao = productsDb.dao
}