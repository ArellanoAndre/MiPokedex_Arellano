package Arell.Andre.composepokedex.components

import Arell.Andre.composepokedex.domain.Pokemon
import Arell.Andre.composepokedex.dummies.showAllPokemons
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuPokedex(
    pokemonList: List<Pokemon>,
    innerPadding: PaddingValues = PaddingValues(),
    onPokemonClick: (Pokemon) -> Unit = {}
) {

    val favorites = pokemonList.filter {
        it.fav
    }

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

        // =========================
        // ENCABEZADO
        // =========================

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 18.dp,
                    bottom = 14.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "POKÉDEX",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Pokémon Collection",
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 13.sp
            )
        }

        // =========================
        // CONTENIDO
        // =========================

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(
                        topStart = 26.dp,
                        topEnd = 26.dp
                    )
                )
                .padding(top = 14.dp)
        ) {

            // =====================
            // MIS FAVORITOS
            // =====================

            Text(
                text = "Mis Favoritos",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                textAlign = TextAlign.Center,
                color = Color(0xFF252525),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 12.dp
                    ),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(
                            rememberScrollState()
                        )
                        .padding(
                            horizontal = 10.dp,
                            vertical = 10.dp
                        ),
                    horizontalArrangement =
                        Arrangement.spacedBy(8.dp)
                ) {

                    favorites.forEach { pokemon ->

                        FavoritePokemon(
                            pokemon = pokemon,
                            onClick = onPokemonClick
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =====================
            // TODOS
            // =====================

            Text(
                text = "Todos mis Pokémon",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Center,
                color = Color(0xFF252525),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    bottom = 18.dp
                ),
                horizontalArrangement =
                    Arrangement.spacedBy(2.dp),
                verticalArrangement =
                    Arrangement.spacedBy(4.dp)
            ) {

                items(
                    items = pokemonList,
                    key = {
                        it.number
                    }
                ) { pokemon ->

                    PokemonRow(
                        pokemon = pokemon,
                        onClick = onPokemonClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun FavoritePokemon(
    pokemon: Pokemon,
    onClick: (Pokemon) -> Unit = {}
) {

    Column(
        modifier = Modifier
            .width(76.dp)
            .clickable {
                onClick(pokemon)
            }
            .padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(68.dp)
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(14.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(
                    id = pokemon.image
                ),
                contentDescription =
                    "${pokemon.name} favorite image",
                modifier = Modifier
                    .size(60.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "#${
                    pokemon.number
                        .toString()
                        .padStart(3, '0')
                }",
                color = getTypeColor(
                    pokemon.type
                ),
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(3.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = pokemon.name,
            color = Color(0xFF252525),
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuPokedex() {

    MenuPokedex(
        pokemonList = showAllPokemons()
    )
}