package com.example.spectacle.presentation.di.core

import android.content.Context
import com.example.spectacle.presentation.di.artist.ArtistSubComponent
import com.example.spectacle.presentation.di.movie.MovieSubComponent
import com.example.spectacle.presentation.di.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        ArtistSubComponent::class,
        MovieSubComponent::class,
        TvShowSubComponent::class
    ])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }

}