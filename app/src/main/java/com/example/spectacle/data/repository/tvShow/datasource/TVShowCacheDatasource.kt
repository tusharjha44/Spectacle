package com.example.spectacle.data.repository.tvShow.datasource

import com.example.spectacle.data.model.tvshow.TVShow

interface TVShowCacheDatasource{

    suspend fun getTVShowsFromCache(): List<TVShow>
    suspend fun saveTVShowsToCache(tvShows: List<TVShow>)

}