package com.example.spectacle.domain.useCase

import com.example.spectacle.data.model.movie.Movie
import com.example.spectacle.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
  suspend fun execute():List<Movie>? = movieRepository.getMovies()
}