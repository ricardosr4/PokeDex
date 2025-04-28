package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.pokedex.presentation.home.HomeScreen
import com.example.pokedex.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel : HomeViewModel by viewModels()
        setContent {
            HomeScreen(viewModel)

        }
    }
}

