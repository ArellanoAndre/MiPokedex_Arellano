package Arell.Andre.composepokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import Arell.Andre.composepokedex.domain.Pokemon
import Arell.Andre.composepokedex.dummies.getOnePokemon
import Arell.Andre.composepokedex.ui.theme.PurpleGrey40
import Arell.Andre.composepokedex.ui.theme.OffWhite

@Composable
fun PokemonGridItem(pokemon: Pokemon, onNavigationDetail:(id:Int) ->Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier.clickable(onClick ={ onNavigationDetail(pokemon.number)})
    ) {
        Box() {
            Image(
                painter = painterResource(pokemon.image),
                contentDescription = pokemon.description
            )
            Row(
                Modifier
                    .size(15.dp, 15.dp)
                    .background(PurpleGrey40, shape = RoundedCornerShape(40.dp))
                    .align(Alignment.TopEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${pokemon.number}",
                    color = OffWhite,
                    textAlign = TextAlign.Center,
                    fontSize = 8.sp
                )
            }

        }
        Text(text = pokemon.name, textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonItemPreview() {
    PokemonGridItem(getOnePokemon(), {id->{}})
}