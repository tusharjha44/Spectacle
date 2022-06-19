package com.example.spectacle.data.repository.movie.datasource

import com.example.spectacle.data.model.movie.Movie

interface MovieCacheDatasource {

    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movie: List<Movie>)

}