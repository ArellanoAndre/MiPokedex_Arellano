package Arell.Andre.composepokedex.utilities

import androidx.compose.ui.graphics.Color
import Arell.Andre.composepokedex.domain.Pokemon
import Arell.Andre.composepokedex.ui.theme.Bug
import Arell.Andre.composepokedex.ui.theme.DarkGray
import Arell.Andre.composepokedex.ui.theme.Electric
import Arell.Andre.composepokedex.ui.theme.Fairy
import Arell.Andre.composepokedex.ui.theme.Fight
import Arell.Andre.composepokedex.ui.theme.Fire
import Arell.Andre.composepokedex.ui.theme.Flying
import Arell.Andre.composepokedex.ui.theme.Ghost
import Arell.Andre.composepokedex.ui.theme.Ground
import Arell.Andre.composepokedex.ui.theme.Normal
import Arell.Andre.composepokedex.ui.theme.OffWhite
import Arell.Andre.composepokedex.ui.theme.Poison
import Arell.Andre.composepokedex.ui.theme.Psych
import Arell.Andre.composepokedex.ui.theme.Rock
import Arell.Andre.composepokedex.ui.theme.Water

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
            dark = false
        }

        else -> color = Normal
    }

    return Pair(color, if(dark) OffWhite else DarkGray)
}