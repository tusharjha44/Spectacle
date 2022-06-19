package com.example.spectacle.data.repository.movie.datasourceImpl

import com.example.spectacle.data.db.MovieDao
import com.example.spectacle.data.model.movie.Movie
import com.example.spectacle.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDao: MovieDao): MovieLocalDatasource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteMovies()
        }
    }


}