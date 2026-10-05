package Arell.Andre.composepokedex.components

import Arell.Andre.composepokedex.domain.Pokemon
import Arell.Andre.composepokedex.dummies.getOnePokemon
import Arell.Andre.composepokedex.ui.theme.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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

@Composable
fun PokemonRow(
    pokemon: Pokemon,
    onClick: (Pokemon) -> Unit = {},
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable {
                onClick(pokemon)
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.96f)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Número
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {

                Text(
                    text = "#${
                        pokemon.number
                            .toString()
                            .padStart(3, '0')
                    }",
                    color = getTypeColor(pokemon.type),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Imagen
            Image(
                painter = painterResource(
                    id = pokemon.image
                ),
                contentDescription = "${pokemon.name} image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(3.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            // Nombre
            Text(
                text = pokemon.name,
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF252525),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                maxLines = 1
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            // Tipo
            Text(
                text = pokemon.type.replace("/", " / "),
                color = Color.White,
                fontSize = 8.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                maxLines = 1,
                modifier = Modifier
                    .background(
                        color = getTypeColor(pokemon.type),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(
                        horizontal = 8.dp,
                        vertical = 3.dp
                    )
            )
        }
    }
}

fun getTypeColor(type: String): Color {

    return when {

        type.contains("Electric", true) ->
            Color(0xFFE5B900)

        type.contains("Fire", true) ->
            Fire

        type.contains("Water", true) ->
            Water

        type.contains("Grass", true) ->
            Grass

        type.contains("Psychic", true) ->
            Psych

        type.contains("Fairy", true) ->
            Fairy

        type.contains("Dragon", true) ->
            Dragon

        type.contains("Fighting", true) ->
            Fight

        type.contains("Poison", true) ->
            Poison

        type.contains("Ghost", true) ->
            Ghost

        type.contains("Flying", true) ->
            Flying

        else ->
            Color(0xFF607D8B)
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonRowPreview() {

    PokemonRow(
        pokemon = getOnePokemon()
    )
}