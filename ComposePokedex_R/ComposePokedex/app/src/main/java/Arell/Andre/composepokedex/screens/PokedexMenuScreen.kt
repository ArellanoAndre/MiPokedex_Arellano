package Arell.Andre.composepokedex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
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
import Arell.Andre.composepokedex.components.PokemonGridItem
import Arell.Andre.composepokedex.domain.Pokemon
import Arell.Andre.composepokedex.dummies.showAllPokemons

@Composable
fun PokedexMenuScreen(pokemonList: List<Pokemon>, onNavigationDetail:(id:Int) ->Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE3350D),
                        Color(0xFFEF5350)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = "POKEDEX",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                items(pokemonList) { pokemon ->
                    PokemonGridItem(pokemon, onNavigationDetail)
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexMenuScreenPreview() {
    PokedexMenuScreen(showAllPokemons(), onNavigationDetail = {})
}