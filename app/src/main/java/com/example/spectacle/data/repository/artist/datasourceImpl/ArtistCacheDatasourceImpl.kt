package com.example.spectacle.data.repository.artist.datasourceImpl

import com.example.spectacle.data.model.artist.Artist
import com.example.spectacle.data.repository.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl : ArtistCacheDatasource{

    private var artistsList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistsList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList = ArrayList(artists)
    }

}