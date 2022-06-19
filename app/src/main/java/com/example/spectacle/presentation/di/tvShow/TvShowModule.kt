package com.example.spectacle.presentation.di.tvShow

import com.example.spectacle.domain.useCase.GetArtistsUseCase
import com.example.spectacle.domain.useCase.GetTvShowsUseCase
import com.example.spectacle.domain.useCase.UpdateArtistsUseCase
import com.example.spectacle.domain.useCase.UpdateTvShowsUseCase
import com.example.spectacle.presentation.artist.ArtistViewModelFactory
import com.example.spectacle.presentation.tvShow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(
            getTvShowsUseCase
            ,updateTvShowsUseCase
        )
    }

}