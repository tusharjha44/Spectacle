package com.example.spectacle.data.repository.movie.datasourceImpl

import com.example.spectacle.data.db.MovieDao
import com.example.spectacle.data.model.movie.Movie
import com.example.spectacle.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasourceImpl: MovieCacheDatasource {

    private var moviesList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}