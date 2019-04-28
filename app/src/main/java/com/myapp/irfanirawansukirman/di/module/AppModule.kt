package com.myapp.irfanirawansukirman.di.module

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.myapp.irfanirawansukirman.MyApp
import com.myapp.irfanirawansukirman.data.source.local.AppPersistance
import dagger.Module
import dagger.Provides
import id.ac.unpad.profolio.util.PreferenceUtil
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, NetworkModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: MyApp): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideSharePrefence(context: Context) : SharedPreferences {
        return context.getSharedPreferences(PreferenceUtil::class.java.simpleName, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): AppPersistance {
        return Room
            .databaseBuilder(
                context.applicationContext,
                AppPersistance::class.java,
                "Movie.db"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

}