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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokemonRow(
    pokemon: Pokemon,
    onClick: (Pokemon) -> Unit = {}
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 6.dp
            )
            .clickable {
                onClick(pokemon)
            },
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Imagen real del Pokémon
            Box(
                modifier = Modifier
                    .size(85.dp)
                    .background(
                        color = Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(15.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(
                        id = pokemon.image
                    ),
                    contentDescription = "${pokemon.name} image",
                    modifier = Modifier
                        .size(75.dp)
                        .padding(5.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            // Información
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = pokemon.name,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkGray
                    )

                    Text(
                        text = "#${
                            pokemon.number
                                .toString()
                                .padStart(3, '0')
                        }",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .background(
                                color = getTypeColor(pokemon.type),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(
                                horizontal = 7.dp,
                                vertical = 3.dp
                            )
                    )
                }

                // Tipo
                Text(
                    text = pokemon.type.replace("/", " / "),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = getTypeColor(pokemon.type)
                )

                // Descripción
                Text(
                    text = pokemon.description,
                    fontSize = 10.sp,
                    lineHeight = 14.sp,
                    color = Color(0xFF666666),
                    maxLines = 2
                )

                Spacer(
                    modifier = Modifier.height(2.dp)
                )

                // Altura y peso
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Altura  ${pokemon.height} m",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF444444)
                    )

                    Text(
                        text = "Peso  ${pokemon.weight} kg",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF444444)
                    )
                }

                Text(
                    text = "Ver detalle  ›",
                    modifier = Modifier.align(
                        Alignment.End
                    ),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = getTypeColor(pokemon.type)
                )
            }
        }
    }
}


fun getTypeColor(type: String): Color {

    return when {

        type.contains("Electric", true) ->
            Color(0xFFE0B900)

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