package com.example.spectacle.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spectacle.data.model.artist.Artist


@Dao
interface ArtistDao {

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>

    @Query("DELETE FROM popular_artists")
    suspend fun deleteArtists()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

}