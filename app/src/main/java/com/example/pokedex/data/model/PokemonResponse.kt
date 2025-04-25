package com.example.pokedex.data.model

import com.google.gson.annotations.SerializedName

// Este modelo ahora maneja los detalles completos de un Pokémon (incluyendo la imagen oficial)
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

// Este es el modelo para manejar los detalles completos del Pokémon, incluida la imagen oficial
data class PokemonDetails(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("sprites") val sprites: Sprites
)

data class Sprites(
    @SerializedName("front_default") val frontDefault: String, // Imagen estándar
    @SerializedName("other") val other: OtherSprites
)

data class OtherSprites(
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork // Arte oficial
)

data class OfficialArtwork(
    @SerializedName("front_default") val frontDefault: String // URL del arte oficial
)
