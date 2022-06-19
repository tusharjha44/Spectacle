package com.example.spectacle.data.repository.tvShow.datasource

import com.example.spectacle.data.model.tvshow.TVShow

interface TVShowLocalDatasource {

    suspend fun getTVShowsFromDB(): List<TVShow>
    suspend fun saveTVShowsToDB(tvShows: List<TVShow>)
    suspend fun clearAll()

}