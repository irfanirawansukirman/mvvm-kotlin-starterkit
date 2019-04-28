package com.myapp.irfanirawansukirman.data.source.local.dao

import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.myapp.irfanirawansukirman.data.model.Movie
import io.reactivex.Single

interface MovieDao {

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getMovieById(id: Int): Movie

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovies(movies: List<Movie>)

    @Query("DELETE FROM movie")
    fun deleteAllHeroes()

    @Query("SELECT * FROM movie")
    fun getMovieList(): Single<List<Movie>>

    @Query("SELECT * FROM movie")
    fun getAllMovies(): List<Movie>

}