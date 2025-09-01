package com.supervital.productsdbcompose.di

import android.app.Application
import androidx.room.Room
import com.supervital.productsdbcompose.database.MainDb
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
    fun provideMainDb(app: Application) : MainDb {
        return Room.databaseBuilder(
            app,
            MainDb::class.java,
            "products.db"
        ).build()
    }
}