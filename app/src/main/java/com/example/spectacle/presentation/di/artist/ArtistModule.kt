package com.example.spectacle.presentation.di.artist

import com.example.spectacle.domain.useCase.GetArtistsUseCase
import com.example.spectacle.domain.useCase.UpdateArtistsUseCase
import com.example.spectacle.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistsUseCase
            ,updateArtistsUseCase
        )
    }

}