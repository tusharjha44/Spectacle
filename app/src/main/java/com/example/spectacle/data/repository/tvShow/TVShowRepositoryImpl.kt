package com.example.spectacle.data.repository.tvShow

import android.util.Log
import com.example.spectacle.data.model.tvshow.TVShow
import com.example.spectacle.data.repository.tvShow.datasource.TVShowCacheDatasource
import com.example.spectacle.data.repository.tvShow.datasource.TVShowLocalDatasource
import com.example.spectacle.data.repository.tvShow.datasource.TVShowRemoteDatasource
import com.example.spectacle.domain.repository.TvShowRepository
import java.lang.Exception

class TVShowRepositoryImpl(
    private val tvShowLocalDatasource: TVShowLocalDatasource,
    private val tvShowCacheDatasource: TVShowCacheDatasource,
    private val tvShowRemoteDatasource: TVShowRemoteDatasource
): TvShowRepository {
    override suspend fun getTvShows(): List<TVShow>? {
        return geTVShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TVShow>? {
        val newListOfTvShows = getTVShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTVShowsToDB(newListOfTvShows)
        tvShowCacheDatasource.saveTVShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    private suspend fun getTVShowsFromAPI(): List<TVShow>{

        lateinit var tvShowsList: List<TVShow>

        try {
            val response = tvShowRemoteDatasource.getTVShows()
            val body = response.body()
            if(body!=null){
                tvShowsList = body.TVShows
            }
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }

        return tvShowsList

    }

    private suspend fun getTVShowsFromDB(): List<TVShow>{
        lateinit var tvShowsList: List<TVShow>

        try {
            tvShowsList = tvShowLocalDatasource.getTVShowsFromDB()
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }

        if(tvShowsList.isNotEmpty()){
            return tvShowsList
        }else{
            tvShowsList = getTVShowsFromAPI()
            tvShowLocalDatasource.saveTVShowsToDB(tvShowsList)
        }

        return tvShowsList
    }

    private suspend fun geTVShowsFromCache(): List<TVShow>{
        lateinit var tvShowsList: List<TVShow>

        try {
            tvShowsList = tvShowCacheDatasource.getTVShowsFromCache()
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }

        if(tvShowsList.isNotEmpty()){
            return tvShowsList
        }else{
            tvShowsList = getTVShowsFromDB()
            tvShowCacheDatasource.saveTVShowsToCache(tvShowsList)
        }

        return tvShowsList
    }

}