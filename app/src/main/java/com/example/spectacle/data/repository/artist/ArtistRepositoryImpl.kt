package com.example.spectacle.data.repository.artist

import android.util.Log
import com.example.spectacle.data.model.artist.Artist
import com.example.spectacle.data.model.movie.Movie
import com.example.spectacle.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.spectacle.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.spectacle.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.spectacle.data.repository.movie.datasource.MovieCacheDatasource
import com.example.spectacle.data.repository.movie.datasource.MovieLocalDatasource
import com.example.spectacle.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.spectacle.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDatasource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    private suspend fun getArtistsFromAPI(): List<Artist>{

        lateinit var artistsList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if(body!=null){
                artistsList = body.people
            }
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }

        return artistsList

    }

    private suspend fun getMArtistsFromDB(): List<Artist>{
        lateinit var artistsList: List<Artist>

        try {
            artistsList = artistLocalDatasource.getArtistsFromDB()
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }

        if(artistsList.isNotEmpty()){
            return artistsList
        }else{
            artistsList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistsList)
        }

        return artistsList
    }

    private suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistsList: List<Artist>

        try {
            artistsList = artistCacheDatasource.getArtistsFromCache()
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }

        if(artistsList.isNotEmpty()){
            return artistsList
        }else{
            artistsList = getMArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistsList)
        }

        return artistsList
    }

}