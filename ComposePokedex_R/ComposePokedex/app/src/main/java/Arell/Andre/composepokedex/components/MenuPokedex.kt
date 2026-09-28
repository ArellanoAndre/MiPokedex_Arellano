package Arell.Andre.composepokedex.components

import Arell.Andre.composepokedex.domain.Pokemon
import Arell.Andre.data.pokemonList
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>) {

}

@Preview(showBackground = true)
@Composable
fun previewMenuPokedex() {
    MenuPokedex(pokemonList = pokemonList)
}