package com.example.pokedex.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.pokedex.data.model.PokemonDetails

@Composable
fun ZetaCardItemHome(
    pokemon: PokemonDetails,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(20.dp)
            .clickable { onClick() }
            .border(2.dp, Color.Black, RoundedCornerShape(20.dp))
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Usamos la URL de la imagen oficial
            ZetaImage(imageUrl = pokemon.sprites.other.officialArtwork.frontDefault)

            // Centrar el nombre oficial del Pokémon
            Text(
                text = pokemon.name.capitalize(), // Usamos capitalize() para asegurarnos de que el nombre tenga la primera letra en mayúscula
                modifier = Modifier
                    .padding(10.dp)  // Agregamos un poco de espacio alrededor del texto
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center, // Esto asegura que el texto esté centrado
                fontSize = 20.sp
            )
        }
    }
}


@Composable
fun ZetaImage(imageUrl: String) {
    val image = rememberAsyncImagePainter(imageUrl)

    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    )
}
