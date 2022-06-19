package com.example.spectacle.presentation.di

import com.example.spectacle.presentation.di.artist.ArtistSubComponent
import com.example.spectacle.presentation.di.movie.MovieSubComponent
import com.example.spectacle.presentation.di.tvShow.TvShowSubComponent

interface Injector {
   fun createMovieSubComponent():MovieSubComponent
   fun createTvShowSubComponent(): TvShowSubComponent
   fun createArtistSubComponent(): ArtistSubComponent
}