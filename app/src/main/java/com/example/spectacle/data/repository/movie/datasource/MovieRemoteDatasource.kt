package com.example.spectacle.data.repository.movie.datasource

import com.example.spectacle.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {

    suspend fun getMovies() : Response<MovieList>

}