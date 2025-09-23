package com.supervital.productsdbcompose

import android.app.Application
import com.supervital.data.database.StorageDb
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var storageDb: StorageDb
}