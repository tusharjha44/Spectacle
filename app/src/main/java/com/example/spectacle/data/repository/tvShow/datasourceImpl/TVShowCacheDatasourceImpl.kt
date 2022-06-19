package com.example.spectacle.data.repository.tvShow.datasourceImpl

import com.example.spectacle.data.model.tvshow.TVShow
import com.example.spectacle.data.repository.tvShow.datasource.TVShowCacheDatasource

class TVShowCacheDatasourceImpl: TVShowCacheDatasource {

    private var tvShowsList = ArrayList<TVShow>()

    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return tvShowsList
    }

    override suspend fun saveTVShowsToCache(tvShows: List<TVShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)
    }
}