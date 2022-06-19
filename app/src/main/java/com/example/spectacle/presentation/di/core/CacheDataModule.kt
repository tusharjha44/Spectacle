package com.example.spectacle.presentation.di.core

import com.example.spectacle.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.spectacle.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.example.spectacle.data.repository.movie.datasource.MovieCacheDatasource
import com.example.spectacle.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.example.spectacle.data.repository.tvShow.datasource.TVShowCacheDatasource
import com.example.spectacle.data.repository.tvShow.datasourceImpl.TVShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDatasource(): MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TVShowCacheDatasource {
        return TVShowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }

}