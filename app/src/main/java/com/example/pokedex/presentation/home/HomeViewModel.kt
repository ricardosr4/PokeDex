package com.example.pokedex.presentation.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.model.PokemonList
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

    private val _pokemon = MutableStateFlow<List<PokemonList>>(emptyList())
    val pokemon = _pokemon.asStateFlow()

    init {
        getPokemon()
    }
    private fun getPokemon() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = pokemonRepository.getPokemon()
                _pokemon.value = response ?: emptyList()
            }
        }
    }
}
