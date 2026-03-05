package Arellano.Andre.composepokedex.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import Arellano.Andre.composepokedex.components.PokemonGridItem
import Arellano.Andre.composepokedex.domain.Pokemon
import Arellano.Andre.composepokedex.dummies.showAllPokemons

@Composable
fun PokedexMenuScreen(pokemonList: List<Pokemon>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 5.dp, 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(pokemonList) { pokemon ->
            PokemonGridItem(pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexMenuScreenPreview() {
    PokedexMenuScreen(showAllPokemons())
}