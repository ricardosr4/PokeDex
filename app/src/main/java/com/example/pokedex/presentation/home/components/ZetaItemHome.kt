package com.example.pokedex.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.pokedex.data.model.Type
import com.example.pokedex.ui.theme.bugColor
import com.example.pokedex.ui.theme.darkColor
import com.example.pokedex.ui.theme.darkTypeColor
import com.example.pokedex.ui.theme.dragonColor
import com.example.pokedex.ui.theme.electricColor
import com.example.pokedex.ui.theme.fairyColor
import com.example.pokedex.ui.theme.fightingColor
import com.example.pokedex.ui.theme.fireColor
import com.example.pokedex.ui.theme.flyingColor
import com.example.pokedex.ui.theme.flyingTypeColor
import com.example.pokedex.ui.theme.ghostColor
import com.example.pokedex.ui.theme.grassColor
import com.example.pokedex.ui.theme.groundColor
import com.example.pokedex.ui.theme.iceColor
import com.example.pokedex.ui.theme.normalColor
import com.example.pokedex.ui.theme.normalTypeColor
import com.example.pokedex.ui.theme.poisonColor
import com.example.pokedex.ui.theme.psychicColor
import com.example.pokedex.ui.theme.rockColor
import com.example.pokedex.ui.theme.steelColor
import com.example.pokedex.ui.theme.waterColor
import java.util.Locale

@Composable
fun ZetaCardItemHome(
    pokemon: PokemonDetails,
    onClick: () -> Unit
) {

    val backgroundColor = getBackgroundColorForType(pokemon.types)
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(20.dp)
            .clickable { onClick() }
            .border(2.dp, Color.Black, RoundedCornerShape(20.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(backgroundColor)
        ) {
            ZetaImage(imageUrl = pokemon.sprites.other.officialArtwork.frontDefault)

            Text(
                text = pokemon.name.capitalize(Locale.ROOT),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
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

fun getBackgroundColorForType(types: List<Type>): Color {
    return when {
        types.any { it.type.name == "fire" } -> fireColor
        types.any { it.type.name == "electric" } -> electricColor
        types.any { it.type.name == "grass" } -> grassColor
        types.any { it.type.name == "water" } -> waterColor
        types.any { it.type.name == "psychic" } -> psychicColor
        types.any { it.type.name == "ghost" } -> ghostColor
        types.any { it.type.name == "ice" } -> iceColor
        types.any { it.type.name == "dragon" } -> dragonColor
        types.any { it.type.name == "bug" } -> bugColor
        types.any { it.type.name == "fairy" } -> fairyColor
        types.any { it.type.name == "dark" } -> darkColor
        types.any { it.type.name == "normal" } -> normalColor
        types.any { it.type.name == "fighting" } -> fightingColor
        types.any { it.type.name == "flying" } -> flyingTypeColor
        types.any { it.type.name == "poison" } -> poisonColor
        types.any { it.type.name == "steel" } -> steelColor
        types.any { it.type.name == "rock" } -> rockColor
        types.any { it.type.name == "ground" } -> groundColor
        types.any { it.type.name == "dark" } -> darkTypeColor
        types.any { it.type.name == "flying" } -> flyingTypeColor
        types.any { it.type.name == "normal" } -> normalColor
        types.any { it.type.name == "fighting" } -> fightingColor
        types.any { it.type.name == "flying" } -> flyingTypeColor
        types.any { it.type.name == "poison" } -> poisonColor
        types.any { it.type.name == "steel" } -> steelColor
        types.any { it.type.name == "flying" } -> flyingColor
        types.any { it.type.name == "normal" } -> normalTypeColor
        else -> Color.Gray
    }
}
