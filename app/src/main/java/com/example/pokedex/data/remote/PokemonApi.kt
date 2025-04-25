package com.example.pokedex.data.remote

import com.example.pokedex.data.model.PokemonResponse
import com.example.pokedex.data.model.PokemonDetails
import com.example.pokedex.utils.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET(ENDPOINT)
    suspend fun getPokemonList(): Response<PokemonResponse>

    // Este es el método que obtiene los detalles completos del Pokémon (incluyendo la imagen oficial)
    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: Int): Response<PokemonDetails>  // Cambié para obtener los detalles completos
}
