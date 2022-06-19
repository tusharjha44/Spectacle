package com.example.spectacle.data.api

import com.example.spectacle.data.model.artist.ArtistList
import com.example.spectacle.data.model.movie.MovieList
import com.example.spectacle.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SpectacleService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<MovieList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<ArtistList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<TVShowList>

}