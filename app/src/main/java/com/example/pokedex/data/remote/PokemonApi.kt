package com.example.pokedex.data.remote


import com.example.pokedex.data.model.PokemonResponse
import com.example.pokedex.utils.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET (ENDPOINT)
    suspend fun getPokemon(): Response<PokemonResponse>


}