package Arellano.Andre.composepokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import Arellano.Andre.composepokedex.domain.Pokemon
import Arellano.Andre.composepokedex.dummies.getOnePokemon
import utilities.getColorByType

@Composable
fun PokemonGridItem(pokemon: Pokemon) {

    val colors = getColorByType(pokemon)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box {

            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier.size(150.dp),
                contentScale = ContentScale.Fit
            )

            Row(
                modifier = Modifier
                    .size(width = 35.dp, height = 35.dp)
                    .background(
                        color = colors.first,
                        shape = RoundedCornerShape(40.dp)
                    )
                    .align(Alignment.TopEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "${pokemon.number}",
                    color = colors.second,
                    textAlign = TextAlign.Center
                )
            }
        }

        Text(
            text = "${pokemon.name}",
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonItemPreview() {
    PokemonGridItem(getOnePokemon())
}