package Arell.Andre.composepokedex.components

import Arell.Andre.composepokedex.domain.Pokemon
import Arell.Andre.composepokedex.dummies.showAllPokemons
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuPokedex(
    pokemonList: List<Pokemon>,
    innerPadding: PaddingValues = PaddingValues(),
    onPokemonClick: (Pokemon) -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF23818),
                        Color(0xFFF4514C)
                    )
                )
            )
            .padding(innerPadding)
    ) {

        // Encabezado
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 18.dp,
                    bottom = 10.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "POKÉDEX",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Pokémon Collection",
                fontSize = 13.sp,
                color = Color.White.copy(
                    alpha = 0.85f
                )
            )
        }

        // Lista vertical
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                bottom = 20.dp
            ),
            verticalArrangement = Arrangement.spacedBy(
                2.dp
            )
        ) {

            items(
                items = pokemonList,
                key = { pokemon ->
                    pokemon.number
                }
            ) { pokemon ->

                PokemonRow(
                    pokemon = pokemon,
                    onClick = onPokemonClick
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMenuPokedex() {

    MenuPokedex(
        pokemonList = showAllPokemons()
    )
}