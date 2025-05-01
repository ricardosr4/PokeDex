package com.example.pokedex.presentation.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.presentation.home.HomeViewModel

@Composable
fun ContentHomeScreen(viewModel: HomeViewModel) {
    val pokemon by viewModel.pokemon.collectAsState()


    LazyColumn(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {

        items(pokemon) { item ->
            ZetaCardItemHome(pokemon = item) {}
        }
    }
}