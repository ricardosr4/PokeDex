package com.example.pokedex.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokedex.presentation.home.components.ContentHomeScreen
import com.example.pokedex.presentation.home.components.ZetaSearchView
import com.example.pokedex.presentation.home.components.ZetaTopBar

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Scaffold(
        topBar = {
            ZetaTopBar(title = "Pokedex", showBackButton = false, onClickBackButton = {}, showFavoriteButton = true, onClickFavoriteButton = {})
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {

                ZetaSearchView(viewModel)
                ContentHomeScreen(viewModel)
            }
        }
    )
}




