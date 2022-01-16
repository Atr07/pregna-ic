package com.atr07.pregna

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber

/**
 * Created by Adithya T Raj.
 **/

class MainApplication : Application() {

    companion object {
        lateinit var instance: MainApplication
            private set
        val appContext: Context
            get() {
                return instance.applicationContext
            }
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        Timber.plant(Timber.DebugTree())
    }
}