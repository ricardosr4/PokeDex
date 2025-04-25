package com.example.pokedex.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.model.PokemonList
import com.example.pokedex.data.model.PokemonDetails
import com.example.pokedex.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) : ViewModel() {

    private val _pokemon = MutableStateFlow<List<PokemonDetails>>(emptyList())
    val pokemon = _pokemon.asStateFlow()

    init {
        getPokemon()
    }

    private fun getPokemon() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                // Primero obtenemos la lista básica de Pokémon
                val response = pokemonRepository.getPokemon()

                // Luego obtenemos los detalles completos (incluyendo la imagen oficial) de cada Pokémon
                val pokemonDetails = response?.mapNotNull { pokemon ->
                    val id = pokemon.url.split("/")[6].toInt()  // Extraemos el ID desde la URL
                    pokemonRepository.getPokemonDetails(id)
                }

                // Actualizamos el estado con los detalles completos (incluida la imagen oficial)
                _pokemon.value = pokemonDetails ?: emptyList()
            }
        }
    }
}
