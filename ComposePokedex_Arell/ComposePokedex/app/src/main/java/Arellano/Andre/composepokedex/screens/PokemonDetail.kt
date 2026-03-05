package Arellano.Andre.composepokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import Arellano.Andre.composepokedex.components.Ability
import Arellano.Andre.composepokedex.components.Chip
import Arellano.Andre.composepokedex.components.PokemonFooter
import Arellano.Andre.composepokedex.components.PokemonHeader
import Arellano.Andre.composepokedex.R
import Arellano.Andre.composepokedex.domain.Pokemon
import Arellano.Andre.composepokedex.ui.theme.ComposePokedexTheme
import Arellano.Andre.composepokedex.ui.theme.electricYellow
import Arellano.Andre.composepokedex.ui.theme.OffWhite


@Composable
fun PokemonCard(
    name: String,
    weight: Float,
    height: Float,
    description: String,
    ability: String,
    image: Int,
    type: String
) {
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(image),
            contentDescription = name,
            Modifier
                .offset(0.dp, -80.dp)
                .zIndex(2f)
                .size(130.dp),
            contentScale = ContentScale.Fit
        )
        Card(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = OffWhite)
        ) {
            Column(Modifier.fillMaxWidth()) {
                Chip(
                    type,
                    electricYellow,
                    Modifier
                        .padding(top = 70.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp), horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column() {
                        Ability("row", label = "Altura", "${height}m")
                        Ability("row", "Peso", "${weight}kg")
                    }
                    Ability("column", label = "Habilidad", value = ability)
                }

                Row(
                    Modifier
                        .fillMaxWidth(.8f)
                        .align(Alignment.CenterHorizontally)
                        .padding(25.dp)
                ) {
                    Text(description)
                }
                Spacer(modifier = Modifier.weight(1f))

                PokemonFooter()

            }

        }
    }
}

@Composable
fun PokemonDetailScreen(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(electricYellow)
    ) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(
            pokemon.name,
            pokemon.weight,
            pokemon.height,
            pokemon.description,
            pokemon.ability,
            pokemon.image,
            pokemon.type
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePokedexTheme {
        PokemonDetailScreen(
            Pokemon(
                "Pikachu",
                25,
                "Electric",
                "Pokemon amarillo",
                0.4f,
                6f,
                true,
                "Estatíca",
                R.drawable.pikachu
            )
        )
    }
}