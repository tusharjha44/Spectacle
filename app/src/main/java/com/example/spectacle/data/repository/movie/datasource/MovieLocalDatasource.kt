package com.example.spectacle.data.repository.movie.datasource

import com.example.spectacle.data.model.movie.Movie

interface MovieLocalDatasource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movie: List<Movie>)
    suspend fun clearAll()

}