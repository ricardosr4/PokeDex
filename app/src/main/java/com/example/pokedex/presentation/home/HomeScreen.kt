package com.example.pokedex.presentation.home


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@Composable
fun HomeScreen(viewModel: HomeViewModel) {


    val pokemon by viewModel.pokemon.collectAsState()

    LazyColumn {
        items(pokemon){ item ->
            Text(text = item.name)


        }
    }
}