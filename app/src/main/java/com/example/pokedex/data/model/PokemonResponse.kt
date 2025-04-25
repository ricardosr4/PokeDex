package com.example.pokedex.data.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<PokemonList>
)

data class PokemonList(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

