package com.myapp.irfanirawansukirman.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.myapp.irfanirawansukirman.data.model.Movie
import com.myapp.irfanirawansukirman.data.source.local.dao.MovieDao

@Database(entities = [Movie::class], version = 1)
abstract class AppPersistance: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}