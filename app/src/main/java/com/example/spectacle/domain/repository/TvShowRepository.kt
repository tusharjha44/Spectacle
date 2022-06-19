package com.example.spectacle.domain.repository

import com.example.spectacle.data.model.tvshow.TVShow

interface TvShowRepository {
    suspend fun getTvShows():List<TVShow>?
    suspend fun updateTvShows():List<TVShow>?
}