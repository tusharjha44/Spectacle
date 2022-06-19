package com.example.spectacle.data.repository.tvShow.datasource

import com.example.spectacle.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDatasource {

    suspend fun getTVShows() : Response<TVShowList>

}