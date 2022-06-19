package com.example.spectacle.data.repository.tvShow.datasourceImpl

import com.example.spectacle.data.api.SpectacleService
import com.example.spectacle.data.model.tvshow.TVShowList
import com.example.spectacle.data.repository.tvShow.datasource.TVShowRemoteDatasource
import retrofit2.Response

class TVShowRemoteDatasourceImpl(
    private val spectacleService: SpectacleService
    ,private val apiKey: String
)    : TVShowRemoteDatasource{
    override suspend fun getTVShows(): Response<TVShowList> =
        spectacleService.getPopularTVShows(apiKey)
}