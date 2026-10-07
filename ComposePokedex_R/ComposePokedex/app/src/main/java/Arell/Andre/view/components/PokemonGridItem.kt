package Arell.Andre.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import Arell.Andre.model.domain.Pokemon
import Arell.Andre.composepokedex.dummies.getOnePokemon
import Arell.Andre.composepokedex.ui.theme.*

@Composable
fun PokemonGridItem(
    pokemon: Pokemon,
    onNavigationDetail: (id: Int) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(165.dp)
            .clickable {
                onNavigationDetail(pokemon.number)
            },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            // Número del Pokémon
            Text(
                text = "#${pokemon.number.toString().padStart(4, '0')}",
                modifier = Modifier.align(Alignment.TopEnd),
                color = Color(0xFF9E9E9E),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Imagen
                Image(
                    painter = painterResource(id = pokemon.image),
                    contentDescription = pokemon.name,
                    modifier = Modifier.size(85.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                // Nombre
                Text(
                    text = pokemon.name,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkGray,
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                // Tipo
                Box(
                    modifier = Modifier
                        .background(
                            color = getPokemonTypeColor(pokemon.type),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(
                            horizontal = 10.dp,
                            vertical = 3.dp
                        )
                ) {

                    Text(
                        text = pokemon.type,
                        color = Color.White,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                }
            }
        }
    }
}


fun getPokemonTypeColor(type: String): Color {

    return when {

        type.contains("Electric", ignoreCase = true) ->
            Electric

        type.contains("Fire", ignoreCase = true) ->
            Fire

        type.contains("Water", ignoreCase = true) ->
            Water

        type.contains("Grass", ignoreCase = true) ->
            Grass

        type.contains("Psychic", ignoreCase = true) ->
            Psych

        type.contains("Fairy", ignoreCase = true) ->
            Fairy

        type.contains("Dragon", ignoreCase = true) ->
            Dragon

        type.contains("Flying", ignoreCase = true) ->
            Flying

        type.contains("Poison", ignoreCase = true) ->
            Poison

        type.contains("Fighting", ignoreCase = true) ->
            Fight

        type.contains("Rock", ignoreCase = true) ->
            Rock

        type.contains("Ground", ignoreCase = true) ->
            Ground

        type.contains("Bug", ignoreCase = true) ->
            Bug

        type.contains("Ghost", ignoreCase = true) ->
            Ghost

        else ->
            Normal
    }
}


@Preview(showBackground = true)
@Composable
fun PokemonItemPreview() {

    Box(
        modifier = Modifier
            .size(
                width = 140.dp,
                height = 180.dp
            )
            .padding(8.dp)
    ) {

        PokemonGridItem(
            pokemon = getOnePokemon(),
            onNavigationDetail = {}
        )
    }
}