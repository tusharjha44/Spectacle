package com.example.spectacle.data.repository.artist.datasource

import com.example.spectacle.data.model.artist.Artist

interface ArtistCacheDatasource {

    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)

}