package com.example.pokedex.presentation.home


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.pokedex.presentation.home.components.ZetaTopBar


@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    Scaffold(
        topBar = {
            ZetaTopBar(title = "Pokedex") { }
        }
    )
    { ContentHomeScreen(viewModel, it) }

}
@Composable
fun ContentHomeScreen(viewModel: HomeViewModel, paddingValues: PaddingValues){

    val pokemon by viewModel.pokemon.collectAsState()

    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        items(pokemon) { item ->
            Text( text = item.name)

        }
    }
}
