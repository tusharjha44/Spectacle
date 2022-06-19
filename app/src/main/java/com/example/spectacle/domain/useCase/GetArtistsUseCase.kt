package com.example.spectacle.domain.useCase

import com.example.spectacle.data.model.artist.Artist
import com.example.spectacle.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()

}