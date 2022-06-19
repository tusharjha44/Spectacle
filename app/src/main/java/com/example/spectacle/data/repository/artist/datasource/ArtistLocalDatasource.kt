package com.example.spectacle.data.repository.artist.datasource

import com.example.spectacle.data.model.artist.Artist

interface ArtistLocalDatasource {

    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()

}