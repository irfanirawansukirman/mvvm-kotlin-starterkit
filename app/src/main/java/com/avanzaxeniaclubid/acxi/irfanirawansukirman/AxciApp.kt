package com.avanzaxeniaclubid.acxi.irfanirawansukirman

import android.app.Application
import android.content.Context
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class AxciApp : DaggerApplication() {

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
        lateinit var instance: AxciApp

        fun getAppContext(): Context = instance.applicationContext
    }
}