package com.example.spectacle.presentation.di.movie

import com.example.spectacle.domain.useCase.GetMoviesUseCase
import com.example.spectacle.domain.useCase.UpdateMoviesUseCase
import com.example.spectacle.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase
            ,updateMoviesUseCase
        )
    }

}