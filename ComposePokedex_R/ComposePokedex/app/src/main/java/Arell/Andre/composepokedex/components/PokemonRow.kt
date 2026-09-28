package Arell.Andre.composepokedex.components

import Arell.Andre.composepokedex.domain.Pokemon
import Arell.Andre.composepokedex.dummies.getOnePokemon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokemonRow(pokemon: Pokemon) {
    Row(modifier = Modifier.padding(10.dp)) {
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = "${pokemon.name} image",
            modifier = Modifier.size(50.dp)
        )
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(text = pokemon.name)
            Text(text = pokemon.description, fontSize = 10.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonRowPreview() {
    PokemonRow(pokemon = getOnePokemon())
}
