package Arell.Andre.composepokedex.dummies

import Arell.Andre.composepokedex.R
import Arell.Andre.composepokedex.domain.Pokemon

val pokemonList = listOf(

    Pokemon(
        name = "Pikachu",
        number = 25,
        type = "Electric",
        description = "Pikachu, el Pokémon Ratón (#025). Almacena electricidad en sus mejillas.",
        height = 0.4f,
        weight = 6f,
        fav = true,
        ability = "Electricidad Estática",
        image = R.drawable.pikachu,
        evolutions = listOf(
            Pokemon(
                name = "Raichu",
                number = 26,
                type = "Electric",
                description = "Raichu es la evolución de Pikachu.",
                height = 0.8f,
                weight = 30f,
                fav = false,
                ability = "Electricidad Estática",
                image = R.drawable.raichu
            )
        )
    ),

    Pokemon(
        name = "Mew",
        number = 151,
        type = "Psychic",
        description = "Mew posee el mapa genético de todos los Pokémon.",
        height = 0.4f,
        weight = 4.0f,
        fav = true,
        ability = "Sincronía",
        image = R.drawable.mew
    ),

    Pokemon(
        name = "Charizard",
        number = 6,
        type = "Fire/Flying",
        description = "Escupe fuego capaz de fundir rocas.",
        height = 1.7f,
        weight = 90.5f,
        fav = true,
        ability = "Mar Llamas",
        image = R.drawable.charizard
    ),

    Pokemon(
        name = "Blastoise",
        number = 9,
        type = "Water",
        description = "Dispara chorros de agua por los cañones de su caparazón.",
        height = 1.6f,
        weight = 85.5f,
        fav = true,
        ability = "Torrente",
        image = R.drawable.blastoise
    ),

    Pokemon(
        name = "Venusaur",
        number = 3,
        type = "Grass/Poison",
        description = "La flor de su lomo desprende un aroma relajante.",
        height = 2.0f,
        weight = 100.0f,
        fav = true,
        ability = "Espesura",
        image = R.drawable.venusaur
    ),

    Pokemon(
        name = "Lugia",
        number = 249,
        type = "Psychic/Flying",
        description = "Guardían legendario de los mares.",
        height = 5.2f,
        weight = 216.0f,
        fav = true,
        ability = "Presión",
        image = R.drawable.lugia
    ),

    Pokemon(
        name = "Greninja",
        number = 658,
        type = "Water/Dark",
        description = "Pokémon ninja extremadamente veloz.",
        height = 1.5f,
        weight = 40.0f,
        fav = true,
        ability = "Torrente",
        image = R.drawable.greninja,
        evolutions = listOf(
            Pokemon(
                name = "Ash-Greninja",
                number = 6581,
                type = "Water/Dark",
                description = "Forma especial de Greninja.",
                height = 1.5f,
                weight = 40f,
                fav = false,
                ability = "Fuerte Vínculo",
                image = R.drawable.greninja
            )
        )
    ),

    Pokemon(
        name = "Togepi",
        number = 175,
        type = "Fairy",
        description = "Pokémon que trae felicidad.",
        height = 0.3f,
        weight = 1.5f,
        fav = true,
        ability = "Dicha",
        image = R.drawable.togepi,
        evolutions = listOf(
            Pokemon(
                name = "Togetic",
                number = 176,
                type = "Fairy/Flying",
                description = "Evolución de Togepi.",
                height = 0.6f,
                weight = 3.2f,
                fav = false,
                ability = "Dicha",
                image = R.drawable.togetic
            )
        )
    ),

    Pokemon(
        name = "Rayquaza",
        number = 384,
        type = "Dragon/Flying",
        description = "Vive en la capa de ozono.",
        height = 7.0f,
        weight = 206.5f,
        fav = true,
        ability = "Bucle Aire",
        image = R.drawable.rayquaza
    ),

    Pokemon(
        name = "Psyduck",
        number = 54,
        type = "Water",
        description = "Sufre constantes dolores de cabeza.",
        height = 0.8f,
        weight = 19.6f,
        fav = true,
        ability = "Humedad",
        image = R.drawable.psyduck,
        evolutions = listOf(
            Pokemon(
                name = "Golduck",
                number = 55,
                type = "Water",
                description = "Evolución de Psyduck.",
                height = 1.7f,
                weight = 76.6f,
                fav = false,
                ability = "Humedad",
                image = R.drawable.psyduck
            )
        )
    ),

    Pokemon(
        name = "Lucario",
        number = 448,
        type = "Fighting/Steel",
        description = "Puede ver el aura de todos los seres.",
        height = 1.2f,
        weight = 54.0f,
        fav = true,
        ability = "Foco Interno",
        image = R.drawable.lucario
    )
)

fun showAllPokemons(): List<Pokemon> {
    return pokemonList
}

fun getOnePokemon(): Pokemon {
    return pokemonList.random()
}

fun getPokemon(id: Int): Pokemon {
    return pokemonList.first { it.number == id }
}