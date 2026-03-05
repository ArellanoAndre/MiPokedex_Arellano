package Arellano.Andre.composepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import Arellano.Andre.composepokedex.domain.Pokemon
import Arellano.Andre.composepokedex.screens.PokemonDetailScreen
import Arellano.Andre.composepokedex.ui.theme.ComposePokedexTheme

class MainActivity : ComponentActivity() {

    val pokemon = Pokemon(
        "Pikachu",
        25,
        "Electric",
        "Pikachu, el Pokémon Ratón (tipo eléctrico#025), es conocido por almacenar electricidad en sus mejillas rojas, lanzando descargas cuando se enfada o se siente amenazado. Es amarillo con rayas marrones en la espalda, orejas largas con puntas negras y una cola en forma de rayo.",
        0.4f,
        6f,
        true,
        "Electricidad Estática",
        R.drawable.pikachu
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PokemonDetailScreen(
                        pokemon,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}