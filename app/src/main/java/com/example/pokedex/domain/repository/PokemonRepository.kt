package com.example.pokedex.domain.repository

import com.example.pokedex.data.model.PokemonList
import com.example.pokedex.data.model.PokemonDetails
import com.example.pokedex.data.remote.PokemonApi
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokemonApi: PokemonApi) {

    // Obtiene la lista básica de Pokémon (nombre y URL)
    suspend fun getPokemon(): List<PokemonList>? {
        val response = pokemonApi.getPokemonList()
        if (response.isSuccessful) {
            return response.body()?.results
        }
        return null
    }

    // Obtiene los detalles completos de un Pokémon usando su ID (incluye imagen)
    suspend fun getPokemonDetails(id: Int): PokemonDetails? {
        val response = pokemonApi.getPokemonDetails(id)  // Obtiene detalles completos
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}
