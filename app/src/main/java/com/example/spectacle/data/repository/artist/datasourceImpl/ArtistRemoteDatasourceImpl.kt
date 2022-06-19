package com.example.spectacle.data.repository.artist.datasourceImpl

import com.example.spectacle.data.api.SpectacleService
import com.example.spectacle.data.model.artist.ArtistList
import com.example.spectacle.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val spectacleService: SpectacleService
    ,private val apiKey: String
    ):ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> =
        spectacleService.getPopularArtists(apiKey)
}