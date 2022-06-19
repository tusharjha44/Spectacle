package com.example.spectacle.domain.useCase

import com.example.spectacle.data.model.tvshow.TVShow
import com.example.spectacle.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TVShow>?=tvShowRepository.updateTvShows()
}