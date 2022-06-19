package com.example.spectacle.data.repository.tvShow.datasourceImpl

import com.example.spectacle.data.db.TVShowDao
import com.example.spectacle.data.model.tvshow.TVShow
import com.example.spectacle.data.repository.tvShow.datasource.TVShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDatasourceImpl(private val tvShowDao: TVShowDao):TVShowLocalDatasource {
    override suspend fun getTVShowsFromDB(): List<TVShow> {
        return tvShowDao.getTVShows()
    }

    override suspend fun saveTVShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTVShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteTVShows()
        }
    }
}