package com.example.pokedex.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.model.PokemonDetails
import com.example.pokedex.domain.repository.PokemonRepository
import com.example.pokedex.presentation.home.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    private val _pokemonList = MutableStateFlow<List<PokemonDetails>>(emptyList())
    val pokemon = _pokemonList.asStateFlow()

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()

    init {
        loadPokemonList()
    }

    fun onQueryChange(query: String) {
        _homeState.value = _homeState.value.copy(query = query)
    }

    private fun loadPokemonList() {
        viewModelScope.launch {
            _homeState.value = _homeState.value.copy(
                isLoading = true,
                isSuccess = false
            )

            try {
                val response = withContext(Dispatchers.IO) {
                    pokemonRepository.getPokemon()
                } ?: emptyList()

                val pokemonDetails = response.mapNotNull { pokemon ->
                    val id = pokemon.url.trimEnd('/').split("/").lastOrNull()?.toIntOrNull()
                    id?.let { pokemonRepository.getPokemonDetails(it) }
                }

                _pokemonList.value = pokemonDetails

                _homeState.value = _homeState.value.copy(
                    isLoading = false,
                    isSuccess = true
                )
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Error al cargar Pokémon", e)
                _pokemonList.value = emptyList()

                _homeState.value = _homeState.value.copy(
                    isLoading = false,
                    isSuccess = false,
                    showAlertDialog = true
                )
            }
        }
    }


//    fun closeAlertDialog() {
//        _homeState.value = _homeState.value.copy(showAlertDialog = false)
//    }
//
//    fun resetSuccess() {
//        _homeState.value = _homeState.value.copy(isSuccess = false)
//    }
}

