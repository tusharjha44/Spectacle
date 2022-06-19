package com.example.spectacle.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spectacle.data.model.tvshow.TVShow


@Dao
interface TVShowDao {

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTVShows(): List<TVShow>

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteTVShows()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShow: List<TVShow>)

}