package com.avanzaxeniaclubid.acxi.irfanirawansukirman.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.data.model.Movie
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.data.source.local.dao.MovieDao

@Database(entities = [Movie::class], version = 1)
abstract class AppPersistance: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}