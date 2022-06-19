package com.example.spectacle.presentation.di.core

import com.example.spectacle.data.repository.artist.ArtistRepositoryImpl
import com.example.spectacle.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.spectacle.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.spectacle.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.spectacle.data.repository.movie.MoviesRepositoryImpl
import com.example.spectacle.data.repository.movie.datasource.MovieCacheDatasource
import com.example.spectacle.data.repository.movie.datasource.MovieLocalDatasource
import com.example.spectacle.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.spectacle.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.example.spectacle.data.repository.tvShow.TVShowRepositoryImpl
import com.example.spectacle.data.repository.tvShow.datasource.TVShowCacheDatasource
import com.example.spectacle.data.repository.tvShow.datasource.TVShowLocalDatasource
import com.example.spectacle.data.repository.tvShow.datasource.TVShowRemoteDatasource
import com.example.spectacle.domain.repository.ArtistRepository
import com.example.spectacle.domain.repository.MovieRepository
import com.example.spectacle.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieCacheDatasource: MovieCacheDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieRemoteDatasource: MovieRemoteDatasource
    ): MovieRepository{
        return MoviesRepositoryImpl(
            movieRemoteDatasource,
            movieCacheDatasource,
            movieLocalDatasource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TVShowRemoteDatasource,
        tvShowLocalDataSource: TVShowLocalDatasource,
        tvShowCacheDataSource: TVShowCacheDatasource
    ): TvShowRepository {

        return TVShowRepositoryImpl(
            tvShowLocalDataSource,
            tvShowCacheDataSource,
            tvShowRemoteDatasource
        )

    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDatasource,
        artistCacheDataSource: ArtistCacheDatasource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistLocalDataSource,
            artistRemoteDatasource,
            artistCacheDataSource
        )


    }

}