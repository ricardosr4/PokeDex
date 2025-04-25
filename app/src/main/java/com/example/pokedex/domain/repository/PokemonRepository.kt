package com.example.pokedex.domain.repository

import com.example.pokedex.data.model.PokemonList
import com.example.pokedex.data.remote.PokemonApi
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokemonApi: PokemonApi) {
    suspend fun getPokemon(): List<PokemonList>? {
        val response = pokemonApi.getPokemon()
        if (response.isSuccessful){
            return response.body()?.results
        }
        return null
    }
}