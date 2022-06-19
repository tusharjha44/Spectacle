package com.example.spectacle.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.spectacle.data.model.artist.Artist
import com.example.spectacle.data.model.movie.Movie
import com.example.spectacle.data.model.tvshow.TVShow


@Database(entities = [Movie::class, TVShow::class, Artist::class], version = 1, exportSchema = false)
abstract class SpectacleDatabase: RoomDatabase() {

    abstract fun moviesDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract fun tvShowDao(): TVShowDao

}