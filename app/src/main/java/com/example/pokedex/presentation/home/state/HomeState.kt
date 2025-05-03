package com.example.pokedex.presentation.home.state

data class HomeState(
    val query: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val showAlertDialog: Boolean = false,
)
