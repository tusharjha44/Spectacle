package com.example.spectacle.domain.useCase

import com.example.spectacle.data.model.tvshow.TVShow
import com.example.spectacle.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TVShow>?=tvShowRepository.getTvShows()
}