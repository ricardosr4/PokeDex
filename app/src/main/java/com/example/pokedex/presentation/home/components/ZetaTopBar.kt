package com.example.pokedex.presentation.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZetaTopBar(
    title: String,
    showBackButton: Boolean = false,
    onClickBackButton: () -> Unit,
    showFavoriteButton: Boolean = false,
    onClickFavoriteButton: () -> Unit,


    ) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { onClickBackButton() })
                {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        actions = {
            if (showFavoriteButton) {
                IconButton(modifier = Modifier.padding(end = 10.dp),
                    onClick = { onClickFavoriteButton() })
                {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite Icon",

                    )
                }
            }
        }
    )
}








