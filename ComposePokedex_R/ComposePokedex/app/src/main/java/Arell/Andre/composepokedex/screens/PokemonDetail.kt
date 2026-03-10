package Arell.Andre.composepokedex.screens

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import Arell.Andre.composepokedex.components.Ability
import Arell.Andre.composepokedex.components.Chip
import Arell.Andre.composepokedex.components.PokemonFooter
import Arell.Andre.composepokedex.components.PokemonHeader
import Arell.Andre.composepokedex.R
import Arell.Andre.composepokedex.domain.Pokemon
import Arell.Andre.composepokedex.ui.theme.ComposePokedexTheme
import Arell.Andre.composepokedex.ui.theme.ElectricYellow
import Arell.Andre.composepokedex.ui.theme.OffWhite


@Composable
fun PokemonCard(
    pokemon: Pokemon,
    previous: Pokemon?,
    next: Pokemon?,
    onNavigate: (Pokemon) -> Unit
) {

    Box(contentAlignment = Alignment.TopCenter) {

        Image(
            painter = painterResource(pokemon.image),
            contentDescription = pokemon.name,
            modifier = Modifier
                .offset(0.dp, -80.dp)
                .zIndex(2f)
                .size(130.dp),
            contentScale = ContentScale.Fit
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = OffWhite)
        ) {

            Column(Modifier.fillMaxWidth()) {

                Chip(
                    pokemon.type,
                    ElectricYellow,
                    Modifier
                        .padding(top = 70.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Column {
                        Ability("row", label = "Altura", "${pokemon.height}m")
                        Ability("row", "Peso", "${pokemon.weight}kg")
                    }

                    Ability("column", label = "Habilidad", value = pokemon.ability)
                }

                Row(
                    Modifier
                        .fillMaxWidth(.8f)
                        .align(Alignment.CenterHorizontally)
                        .padding(25.dp)
                ) {
                    Text(pokemon.description)
                }

                if (pokemon.evolutions.isNotEmpty()) {

                    Text(
                        text = "Evolutions",
                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                    ) {

                        items(pokemon.evolutions) { evolution ->

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {

                                Image(
                                    painter = painterResource(evolution.image),
                                    contentDescription = evolution.name,
                                    modifier = Modifier.size(50.dp)
                                )

                                Text(
                                    text = evolution.name,
                                    modifier = Modifier.padding(start = 10.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                PokemonFooter(
                    previous = previous,
                    next = next,
                    onNavigate = onNavigate
                )
            }
        }
    }
}


@Composable
fun PokemonDetailScreen(
    pokemon: Pokemon,
    neighbors: Pair<Pokemon?, Pokemon?>,
    onNavigate: (Pokemon) -> Unit,
    modifier: Modifier = Modifier
) {

    val previous = neighbors.first
    val next = neighbors.second

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ElectricYellow)
    ) {

        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)

        PokemonCard(
            pokemon,
            previous,
            next,
            onNavigate
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    ComposePokedexTheme {

        PokemonDetailScreen(
            pokemon = Pokemon(
                "Pikachu",
                25,
                "Electric",
                "Pokemon amarillo",
                0.4f,
                6f,
                true,
                "Estática",
                R.drawable.pikachu
            ),
            neighbors = Pair(null, null),
            onNavigate = {}
        )
    }
}