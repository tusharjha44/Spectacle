package com.example.spectacle.data.repository.artist.datasource

import com.example.spectacle.data.model.artist.ArtistList
import com.example.spectacle.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDatasource {

    suspend fun getArtists() : Response<ArtistList>

}