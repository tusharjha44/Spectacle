package com.example.spectacle.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.spectacle.data.db.ArtistDao
import com.example.spectacle.data.db.MovieDao
import com.example.spectacle.data.db.SpectacleDatabase
import com.example.spectacle.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): SpectacleDatabase{
        return Room.databaseBuilder(
            context,
            SpectacleDatabase::class.java,
            "spectacleClient"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(spectacleDatabase: SpectacleDatabase): MovieDao{
        return spectacleDatabase.moviesDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(spectacleDatabase: SpectacleDatabase): TVShowDao{
        return spectacleDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(spectacleDatabase: SpectacleDatabase): ArtistDao{
        return spectacleDatabase.artistDao()
    }

}