package com.example.spectacle.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spectacle.data.model.movie.Movie


@Dao
interface MovieDao {

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>

    @Query("DELETE FROM popular_movies")
    suspend fun deleteMovies()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

}