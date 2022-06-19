package com.example.spectacle.data.repository.movie

import android.util.Log
import com.example.spectacle.data.model.movie.Movie
import com.example.spectacle.data.repository.movie.datasource.MovieCacheDatasource
import com.example.spectacle.data.repository.movie.datasource.MovieLocalDatasource
import com.example.spectacle.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.spectacle.domain.repository.MovieRepository
import java.lang.Exception

class MoviesRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieCacheDatasource: MovieCacheDatasource,
    private val movieLocalDatasource: MovieLocalDatasource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Movie>{

        lateinit var moviesList: List<Movie>

        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if(body!=null){
                moviesList = body.movies
            }
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }

        return moviesList

    }

    private suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var moviesList: List<Movie>

        try {
            moviesList = movieLocalDatasource.getMoviesFromDB()
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }

        if(moviesList.isNotEmpty()){
            return moviesList
        }else{
            moviesList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(moviesList)
        }

        return moviesList
    }

    private suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var moviesList: List<Movie>

        try {
            moviesList = movieCacheDatasource.getMoviesFromCache()
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }

        if(moviesList.isNotEmpty()){
            return moviesList
        }else{
            moviesList = getMoviesFromDB()
            movieCacheDatasource.saveMoviesToCache(moviesList)
        }

        return moviesList
    }

}