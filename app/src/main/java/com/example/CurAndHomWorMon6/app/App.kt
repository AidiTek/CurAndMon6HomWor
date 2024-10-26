package com.projectx.CurAndHomWorMon6.app

import android.app.Application
import com.example.CurAndHomWorMon6.di.repositoryModule
import com.example.CurAndHomWorMon6.di.viewModelModule
import com.projectx.CurAndHomWorMon6.di.appModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

@HiltAndroidApp
class App:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }
    }
}