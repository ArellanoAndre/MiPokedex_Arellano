package Arell.Andre.view.components

import Arell.Andre.model.domain.Pokemon
import Arell.Andre.composepokedex.dummies.showAllPokemons
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items as listItems
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items as gridItems
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
    onPokemonClick: (Pokemon) -> Unit = {},
    isGrid: Boolean = false,
    onGridChange: (Boolean) -> Unit = {},
    onLogout: () -> Unit = {}
) {
    val favorites = pokemonList.filter { it.fav }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFF23818), Color(0xFFF4514C))))
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 18.dp, bottom = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("POKÉDEX", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text("Pokémon Collection", color = Color.White.copy(alpha = 0.85f), fontSize = 13.sp)
        }
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color(0xFFF5F5F5), RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .padding(top = 14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Mis Favoritos", color = Color(0xFF252525), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                OutlinedButton(onClick = onLogout) { Text("Cerrar sesión") }
            }
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    favorites.forEach { pokemon ->
                        FavoritePokemon(pokemon = pokemon, onClick = onPokemonClick)
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Todos mis Pokémon", color = Color(0xFF252525), fontSize = 19.sp, fontWeight = FontWeight.Bold)
                OutlinedButton(onClick = { onGridChange(!isGrid) }) {
                    Text(if (isGrid) "Lista" else "Cuadrícula")
                }
            }
            if (isGrid) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    contentPadding = PaddingValues(start = 10.dp, end = 10.dp, bottom = 18.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    gridItems(pokemonList, key = { it.number }) { pokemon ->
                        PokemonRow(pokemon, onClick = onPokemonClick, modifier = Modifier.fillMaxWidth())
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listItems(pokemonList, key = { it.number }) { pokemon ->
                        Card(onClick = { onPokemonClick(pokemon) }, modifier = Modifier.fillMaxWidth()) {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(pokemon.image),
                                    contentDescription = pokemon.name,
                                    modifier = Modifier.size(64.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(Modifier.width(12.dp))
                                Column {
                                    Text(pokemon.name, fontWeight = FontWeight.Bold)
                                    Text("#${pokemon.number} · ${pokemon.type}")
                                    Text(pokemon.description, maxLines = 2, fontSize = 12.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FavoritePokemon(pokemon: Pokemon, onClick: (Pokemon) -> Unit = {}) {
    Column(
        modifier = Modifier.width(76.dp).clickable { onClick(pokemon) }.padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(68.dp).background(Color(0xFFF5F5F5), RoundedCornerShape(14.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(pokemon.image),
                contentDescription = "${pokemon.name} favorite image",
                modifier = Modifier.size(60.dp).padding(4.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "#${pokemon.number.toString().padStart(3, '0')}",
                color = getTypeColor(pokemon.type), fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.TopEnd).padding(3.dp)
            )
        }
        Spacer(Modifier.height(4.dp))
        Text(
            text = pokemon.name, color = Color(0xFF252525), fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center, maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuPokedex() {
    MenuPokedex(pokemonList = showAllPokemons())
}
