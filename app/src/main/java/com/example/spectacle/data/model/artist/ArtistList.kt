package com.example.spectacle.data.model.artist


import com.example.spectacle.data.model.artist.Artist
import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val people: List<Artist>
)