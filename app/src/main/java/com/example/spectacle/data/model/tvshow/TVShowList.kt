package com.example.spectacle.data.model.tvshow


import com.example.spectacle.data.model.tvshow.TVShow
import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val TVShows: List<TVShow>
)