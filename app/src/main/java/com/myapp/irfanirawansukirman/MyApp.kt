package com.myapp.irfanirawansukirman

import android.content.Context
import com.myapp.irfanirawansukirman.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class MyApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        // Start setup timber logging
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        // End setup timber logging
    }

    companion object {
        lateinit var instance: MyApp

        fun getAppContext(): Context = instance.applicationContext
    }
}