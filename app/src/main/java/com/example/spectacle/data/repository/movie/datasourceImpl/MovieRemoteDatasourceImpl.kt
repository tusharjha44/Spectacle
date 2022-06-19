package com.example.spectacle.data.repository.movie.datasourceImpl

import com.example.spectacle.data.api.SpectacleService
import com.example.spectacle.data.model.movie.MovieList
import com.example.spectacle.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val spectacleService: SpectacleService,
    private val apiKey: String
): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = spectacleService.getPopularMovies(apiKey)
}