package utilities

import androidx.compose.ui.graphics.Color
import Arellano.Andre.composepokedex.domain.Pokemon
import Arellano.Andre.composepokedex.ui.theme.Bug
import Arellano.Andre.composepokedex.ui.theme.Electric
import Arellano.Andre.composepokedex.ui.theme.Fairy
import Arellano.Andre.composepokedex.ui.theme.Fight
import Arellano.Andre.composepokedex.ui.theme.Fire
import Arellano.Andre.composepokedex.ui.theme.Flying
import Arellano.Andre.composepokedex.ui.theme.Ghost
import Arellano.Andre.composepokedex.ui.theme.Ground
import Arellano.Andre.composepokedex.ui.theme.Normal
import Arellano.Andre.composepokedex.ui.theme.Poison
import Arellano.Andre.composepokedex.ui.theme.Psych
import Arellano.Andre.composepokedex.ui.theme.Rock
import Arellano.Andre.composepokedex.ui.theme.Water

fun getColorByType(pokemon: Pokemon): Pair<Color, Color> {

    var color: Color
    var dark = true

    when {
        pokemon.type.lowercase().contains("normal") -> color = Normal

        pokemon.type.lowercase().contains("electric") -> {
            color = Electric
            dark = false
        }

        pokemon.type.lowercase().contains("water") -> {
            color = Water
        }

        pokemon.type.lowercase().contains("fire") -> color = Fire

        pokemon.type.lowercase().contains("fairy") -> {
            color = Fairy
            dark = false
        }

        pokemon.type.lowercase().contains("psychic") -> {
            color = Psych
        }

        pokemon.type.lowercase().contains("fighting") -> {
            color = Fight
        }

        pokemon.type.lowercase().contains("ghost") -> color = Ghost
        pokemon.type.lowercase().contains("bug") -> color = Bug
        pokemon.type.lowercase().contains("poison") -> color = Poison
        pokemon.type.lowercase().contains("ground") -> color = Ground
        pokemon.type.lowercase().contains("rock") -> color = Rock

        pokemon.type.lowercase().contains("flying") -> {
            color = Flying
        }

        else -> color = Normal
    }

    return Pair(color, color)
}