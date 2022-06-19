package com.example.spectacle.presentation.di.core

import com.example.spectacle.data.api.SpectacleService
import com.example.spectacle.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.spectacle.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.example.spectacle.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.spectacle.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.example.spectacle.data.repository.tvShow.datasource.TVShowRemoteDatasource
import com.example.spectacle.data.repository.tvShow.datasourceImpl.TVShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDatasource(spectacleService: SpectacleService): MovieRemoteDatasource{
        return MovieRemoteDatasourceImpl(
            spectacleService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDatasource(spectacleService: SpectacleService): ArtistRemoteDatasource{
        return ArtistRemoteDatasourceImpl(
            spectacleService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDatasource(spectacleService: SpectacleService): TVShowRemoteDatasource{
        return TVShowRemoteDatasourceImpl(
            spectacleService,apiKey
        )
    }


}