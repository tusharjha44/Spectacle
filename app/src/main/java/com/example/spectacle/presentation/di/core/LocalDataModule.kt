package com.example.spectacle.presentation.di.core

import com.example.spectacle.data.db.ArtistDao
import com.example.spectacle.data.db.MovieDao
import com.example.spectacle.data.db.TVShowDao
import com.example.spectacle.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.spectacle.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.example.spectacle.data.repository.movie.datasource.MovieLocalDatasource
import com.example.spectacle.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.example.spectacle.data.repository.tvShow.datasource.TVShowLocalDatasource
import com.example.spectacle.data.repository.tvShow.datasourceImpl.TVShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDatasource(movieDao: MovieDao): MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDatasource(artistDao: ArtistDao): ArtistLocalDatasource{
        return ArtistLocalDatasourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDatasource(tvShowDao: TVShowDao): TVShowLocalDatasource{
        return TVShowLocalDatasourceImpl(tvShowDao)
    }

}