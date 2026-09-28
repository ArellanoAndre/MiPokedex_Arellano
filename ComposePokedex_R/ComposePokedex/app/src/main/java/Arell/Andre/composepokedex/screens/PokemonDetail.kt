package Arell.Andre.composepokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import Arell.Andre.composepokedex.R
import Arell.Andre.composepokedex.components.Chip
import Arell.Andre.composepokedex.components.PokemonDescription
import Arell.Andre.composepokedex.components.PokemonFooter
import Arell.Andre.composepokedex.components.PokemonHeader
import Arell.Andre.composepokedex.components.PokemonStats
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

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {

        // Imagen principal del Pokémon
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = pokemon.name,
            modifier = Modifier
                .offset(y = (-75).dp)
                .zIndex(2f)
                .size(150.dp),
            contentScale = ContentScale.Fit
        )

        Card(
            modifier = Modifier.fillMaxSize(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = OffWhite
            )
        ) {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                // Tipo del Pokémon
                Chip(
                    text = pokemon.type,
                    color = ElectricYellow,
                    modifier = Modifier
                        .padding(top = 85.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Nuevo Composable de estadísticas
                PokemonStats(
                    height = pokemon.height,
                    weight = pokemon.weight,
                    ability = pokemon.ability
                )

                // Nuevo Composable de descripción
                PokemonDescription(
                    description = pokemon.description
                )

                // Evoluciones
                if (pokemon.evolutions.isNotEmpty()) {

                    Text(
                        text = "EVOLUCIONES",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1F1F1F),
                        modifier = Modifier.padding(
                            start = 20.dp,
                            top = 5.dp,
                            bottom = 5.dp
                        )
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                    ) {

                        items(pokemon.evolutions) { evolution ->

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Image(
                                    painter = painterResource(
                                        id = evolution.image
                                    ),
                                    contentDescription = evolution.name,
                                    modifier = Modifier.size(55.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(
                                    modifier = Modifier.width(12.dp)
                                )

                                Column {

                                    Text(
                                        text = evolution.name,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )

                                    Text(
                                        text = "#${
                                            evolution.number
                                                .toString()
                                                .padStart(4, '0')
                                        }",
                                        fontSize = 11.sp,
                                        color = Color.Gray
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(
                    modifier = Modifier.weight(1f)
                )

                // Navegación entre Pokémon
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

        PokemonHeader(
            name = pokemon.name,
            number = pokemon.number,
            fav = pokemon.fav
        )

        PokemonCard(
            pokemon = pokemon,
            previous = previous,
            next = next,
            onNavigate = onNavigate
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {

    ComposePokedexTheme {

        PokemonDetailScreen(
            pokemon = Pokemon(
                name = "Pikachu",
                number = 25,
                type = "Electric",
                description = "Pikachu, el Pokémon Ratón. Almacena electricidad en sus mejillas.",
                height = 0.4f,
                weight = 6f,
                fav = true,
                ability = "Electricidad Estática",
                image = R.drawable.pikachu
            ),
            neighbors = Pair(null, null),
            onNavigate = {}
        )
    }
}