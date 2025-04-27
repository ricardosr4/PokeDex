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

data class PokemonDetails(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("types") val types: List<Type>
)

data class Sprites(
    @SerializedName("front_default") val frontDefault: String,
    @SerializedName("other") val other: OtherSprites
)

data class OtherSprites(
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @SerializedName("front_default") val frontDefault: String
)

data class Type(
    @SerializedName("type") val type: TypeInfo
)

data class TypeInfo(
    @SerializedName("name") val name: String
)
