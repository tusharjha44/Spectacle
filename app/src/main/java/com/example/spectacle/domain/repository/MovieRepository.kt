package com.example.spectacle.domain.repository

import com.example.spectacle.data.model.movie.Movie


interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}